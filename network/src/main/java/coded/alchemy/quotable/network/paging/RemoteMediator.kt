package coded.alchemy.quotable.network.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.network.QuotableApi
import androidx.paging.RemoteMediator
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

@OptIn(ExperimentalPagingApi::class)
class RemoteMediator(
    private val database: QuotableDatabase,
    private val quotableApi: QuotableApi
) : RemoteMediator<Int, QuoteEntity>() {

    private val dao = database.quoteDao()
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, QuoteEntity>
    ): MediatorResult {
        return try {
            // The network load method takes an optional after=<user.id>
            // parameter. For every page after the first, pass the last user
            // ID to let it continue from where it left off. For REFRESH,
            // pass null to load the first page.
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                // In this example, you never need to prepend, since REFRESH
                // will always load the first page in the list. Immediately
                // return, reporting end of pagination.
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)

                LoadType.APPEND -> {
                    // You must explicitly check if the last item is null when
                    // appending, since passing null to networkService is only
                    // valid for initial load. If lastItem is null it means no
                    // items were loaded after the initial REFRESH and there are
                    // no more items to load.
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(endOfPaginationReached = true)

                    lastItem.quoteId
                }
            }

            // Suspending network load via Retrofit. This doesn't need to be
            // wrapped in a withContext(Dispatcher.IO) { ... } block since
            // Retrofit's Coroutine CallAdapter dispatches on a worker
            // thread.
            val response = quotableApi.getQuotes(STARTING_PAGE_INDEX)

            withContext(Dispatchers.IO) {
                if (loadType == LoadType.REFRESH) {
//                    dao.deleteByQuery(query)
                }

                // Insert new users into database, which invalidates the
                // current PagingData, allowing Paging to present the updates
                // in the DB.
                for (quote in response.results) {
                    val quoteEntity =
                        QuoteEntity(
                            quoteId = quote._id,
                            authorId = null,
                            content = quote.content,
                            author_slug = quote.authorSlug,
                            length = quote.length.toLong(),
                            date_added = quote.dateAdded,
                            date_modified = quote.dateModified
                        )
                    dao.insertQuote(quoteEntity)

                    val author =
                        Author(name = quote.author, slug = quote.authorSlug, authorId = null)
                    dao.insertAuthor(author)

                    for (content in quote.tags) {
                        dao.insertTag(Tag(tagId = null, quoteId = quote._id, content = content))
                    }
                }
            }

            MediatorResult.Success(endOfPaginationReached = false)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}