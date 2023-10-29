package coded.alchemy.quotable.network.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.RemoteKey
import coded.alchemy.qoutable.database.data.Tag
import coded.alchemy.quotable.data.AuthorRepository
import coded.alchemy.quotable.data.QuoteRepository
import coded.alchemy.quotable.data.TagRepository
import coded.alchemy.quotable.network.QuotableApi
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

@OptIn(ExperimentalPagingApi::class)
class RemoteMediator(
    private val query: String,
    private val database: QuotableDatabase,
    private val quotableApi: QuotableApi
) : RemoteMediator<Int, QuoteEntity>() {

    //    private val quoteDao = database.quoteDao()
//    private val tagDao = database.tagDao()
//    private val authorDao = database.authorDao()
    private val remoteKeyDao = database.remoteKeyDao()

//    override suspend fun initialize(): InitializeAction {
//        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
//        return if (System.currentTimeMillis() - database.lastUpdated() <= cacheTimeout) {
//            // Cached data is up-to-date, so there is no need to re-fetch
//            // from the network.
//            InitializeAction.SKIP_INITIAL_REFRESH
//        } else {
//            // Need to refresh cached data from network; returning
//            // LAUNCH_INITIAL_REFRESH here will also block RemoteMediator's
//            // APPEND and PREPEND from running until REFRESH succeeds.
//            InitializeAction.LAUNCH_INITIAL_REFRESH
//        }
//    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, QuoteEntity>
    ): MediatorResult {
        return try {
            // The network load method takes an optional String
            // parameter. For every page after the first, pass the String
            // token returned from the previous page to let it continue
            // from where it left off. For REFRESH, pass null to load the
            // first page.
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                // In this example, you never need to prepend, since REFRESH
                // will always load the first page in the list. Immediately
                // return, reporting end of pagination.
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)

                LoadType.APPEND -> {
                    // Query remoteKeyDao for the next RemoteKey.
                    val remoteKey = database.withTransaction {
                        remoteKeyDao.remoteKeyByQuery(query)
                    }

                    // You must explicitly check if the page key is null when
                    // appending, since null is only valid for initial load.
                    // If you receive null for APPEND, that means you have
                    // reached the end of pagination and there are no more
                    // items to load.
                    if (remoteKey.nextKey == null) {
                        return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    }

                    remoteKey.nextKey
                }
            }

            // Suspending network load via Retrofit. This doesn't need to be
            // wrapped in a withContext(Dispatcher.IO) { ... } block since
            // Retrofit's Coroutine CallAdapter dispatches on a worker
            // thread.
            val response = quotableApi.getQuotes(STARTING_PAGE_INDEX)

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteKeyDao.deleteByQuery(query)
//                    dao.deleteByQuery(query)
                }

                // Update RemoteKey for this query.
                remoteKeyDao.insertOrReplace(
                    RemoteKey(query, response.page)
                )

                // Insert into database, which invalidates the
                // current PagingData, allowing Paging to present the updates
                // in the DB.
                loadDatabase(response.results)
            }

            MediatorResult.Success(endOfPaginationReached = false)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun loadDatabase(quoteList: List<Quote>) {
        for (quote in quoteList) {
            val quoteEntity =
                QuoteEntity(
                    quoteId = quote._id,
                    content = quote.content,
                    author_slug = quote.authorSlug,
                    length = quote.length.toLong(),
                    date_added = quote.dateAdded,
                    date_modified = quote.dateModified
                )
            QuoteRepository.getInstance(database.quoteDao()).insertQuote(quoteEntity)

            val author =
                Author(name = quote.author, slug = quote.authorSlug, authorId = Long.MAX_VALUE)
            AuthorRepository.getInstance(database.authorDao()).insertAuthor(author)

            for (content in quote.tags) {
                TagRepository.getInstance(database.tagDao())
                    .insertTag(Tag(tagId = Long.MAX_VALUE, quoteId = quote._id, content = content))
            }
        }
    }
}
