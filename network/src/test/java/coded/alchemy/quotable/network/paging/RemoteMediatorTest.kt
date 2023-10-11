package coded.alchemy.quotable.network.paging

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.network.QuotableApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

@OptIn(ExperimentalPagingApi::class, ExperimentalCoroutinesApi::class)
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
//            LoadType.REFRESH,
//            null
        )
    }

    @Test
    fun `test load when success`() = runBlocking {
        // Arrange
        val expectedQuoteList = listOf(/* mock QuoteEntities here */)
        val response = /* mock response object here */

            `when`(quotableApi.getQuotes(1)).thenReturn(response)

        // Act
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)

        // Assert
        assert(result is RemoteMediator.MediatorResult.Success)
        // Add further assertions based on specific requirements
    }

    @Test
    fun `test load when failure`() = runBlocking {
        // Arrange
        `when`(quotableApi.getQuotes(1)).thenThrow(/* mock your exception here */)

        // Act
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)

        // Assert
        assert(result is RemoteMediator.MediatorResult.Error)
        // Add further assertions based on your specific requirements
    }
}
