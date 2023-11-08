package coded.alchemy.quotable.network.paging

import android.util.Log
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

    private val TAG = this.javaClass.simpleName

    private val quoteDao = database.quoteDao()
    private val tagDao = database.tagDao()
    private val authorDao = database.authorDao()
    private val remoteKeyDao = database.remoteKeyDao()

    override suspend fun initialize(): InitializeAction {
        Log.d(TAG, "initialize: ")
        val remoteKey = remoteKeyDao.get()
        return if (remoteKey == null) {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, QuoteEntity>
    ): MediatorResult {
        Log.d(TAG, "load: ")
        return try {
            // The network load method takes an optional String
            // parameter. For every page after the first, pass the String
            // token returned from the previous page to let it continue
            // from where it left off. For REFRESH, pass null to load the
            // first page.
            val loadKey = when (loadType) {
                LoadType.REFRESH -> {
                    Log.d(TAG, "Refresh: ")
                    quoteDao.deleteAll()
                    remoteKeyDao.deleteAll()
                    authorDao.deleteAll()
                    tagDao.deleteAll()
                    STARTING_PAGE_INDEX
                }
                LoadType.PREPEND -> {
                    Log.d(TAG, "Prepend: ")
                    return MediatorResult.Success(endOfPaginationReached = true)
                }

                LoadType.APPEND -> {
                    Log.d(TAG, "Append: ")
                    val remoteKey = remoteKeyDao.get()

                    if (remoteKey?.currentPage == remoteKey?.lastPage) {
                        return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    }

                    remoteKey?.currentPage?.plus(1)
                }
            }

            val response = loadKey?.let { key -> quotableApi.getQuotes(key) }

            database.withTransaction {
                response?.let { responseData ->

                    remoteKeyDao.insertOrReplace(
                        RemoteKey(
                            currentPage = responseData.page,
                            lastPage = responseData.totalPages
                        )
                    )

                    loadDatabase(responseData.results)
                }
            }

            MediatorResult.Success(endOfPaginationReached = false)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun loadDatabase(quoteList: List<Quote>) {
        Log.d(TAG, "loadDatabase: ")
        for (quote in quoteList) {
            val author =
                Author(name = quote.author, slug = quote.authorSlug, authorId = Long.MAX_VALUE)
            Log.d(TAG, "Insert Author: ")
            authorDao.insertAuthor(author)

            val quoteEntity =
                QuoteEntity(
                    quoteId = quote._id,
                    content = quote.content,
                    author_slug = quote.authorSlug,
                    length = quote.length.toLong(),
                    date_added = quote.dateAdded,
                    date_modified = quote.dateModified,
                    authorId = author.authorId
                )
            quoteDao.insertQuote(quoteEntity)
            Log.d(TAG, "Insert Quote: ")

            for (content in quote.tags) {
                Log.d(TAG, "Insert Tag: ")
                tagDao
                    .insertTag(Tag(tagId = Long.MAX_VALUE, quoteId = quote._id, content = content))
            }
        }
    }
}
