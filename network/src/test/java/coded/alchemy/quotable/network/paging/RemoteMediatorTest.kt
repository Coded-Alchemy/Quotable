package coded.alchemy.quotable.network.paging

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.network.QuotableApi
import coded.alchemy.quotable.network.QuoteResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

/**
 * RemoteMediatorTest.kt
 *
 * Test for the [RemoteMediator].
 *
 * @author Taji Abdullah
 */
@ExperimentalPagingApi
class RemoteMediatorTest {

    // Rule to make LiveData work with testing
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var remoteMediator: RemoteMediator
    private lateinit var database: QuotableDatabase
    private lateinit var quotableApi: QuotableApi
    private lateinit var pagingState: PagingState<Int, QuoteEntity>

    @Before
    fun setup() {
        database = Mockito.mock(QuotableDatabase::class.java)
        quotableApi = Mockito.mock(QuotableApi::class.java)
        remoteMediator = RemoteMediator("query", database, quotableApi)

        pagingState = PagingState(
            listOf(),
            null,
            PagingConfig(10),
            0
        )
    }

//    @Test
//    fun `test load when success`() = runBlocking {
//        // Arrange
//        val expectedQuoteList = listOf(
//            QuoteEntity(
//                quoteId = "1",
//                authorId = 1,
//                content = "Content 1",
//                author_slug = "author1-slug",
//                length = 100,
//                date_added = "2023-09-21",
//                date_modified = "2023-09-21"
//            ),
//            QuoteEntity(
//                quoteId = "2",
//                authorId = 2,
//                content = "Content 2",
//                author_slug = "author2-slug",
//                length = 200,
//                date_added = "2023-09-22",
//                date_modified = "2023-09-22"
//            )
//        )
//
//        val response = QuoteResponse(results = listOf(Quote(),Quote()))
//
//        `when`(quotableApi.getQuotes(1)).thenReturn(response)
//
//        // Act
//        val result = remoteMediator.load(LoadType.REFRESH, pagingState)
//
//        // Assert
//        assert(result is RemoteMediator.MediatorResult.Success)
//    }

//    @Test
//    fun `test load when failure`() = runBlocking {
//        // Arrange
//        `when`(quotableApi.getQuotes(1)).thenThrow(/* mock exception here */)
//
//        // Act
//        val result = remoteMediator.load(LoadType.REFRESH, pagingState)
//
//        // Assert
//        assert(result is RemoteMediator.MediatorResult.Error)
//    }
}
