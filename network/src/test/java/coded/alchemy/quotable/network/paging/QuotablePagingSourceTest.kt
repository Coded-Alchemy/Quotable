package coded.alchemy.quotable.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coded.alchemy.quotable.network.QuotableApi
import coded.alchemy.quotable.network.QuoteResponse
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Unit tests for the [QuotablePagingSource] class.
 *
 * @author Taji Abdullah
 */
class QuotablePagingSourceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var quotablePagingSource: QuotablePagingSource
    private lateinit var quotableApi: QuotableApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val baseUrl = mockWebServer.url("/").toString()

        quotableApi =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient.Builder().build()) // Use a minimal OkHttpClient for testing
                .addConverterFactory(GsonConverterFactory.create(Gson())) // Use the same Gson instance
                .build()
                .create()

        quotablePagingSource = QuotablePagingSource(quotableApi)
    }

//    @Test
//    fun testLoad_Success() = runBlocking {
//        // Arrange
//        val page = 1
//        val response = createMockResponse()
//        `when`(quotableApi.getQuotes(page)).thenReturn(response)
//
//        // Act
//        val loadParams = PagingSource.LoadParams.Refresh(0, 0, false)
//        val result = quotablePagingSource.load(loadParams)
//
//        // Assert
//        assert(result is PagingSource.LoadResult.Page)
//        val pageResult = result as PagingSource.LoadResult.Page
//        assertEquals(response.results, pageResult.data)
//    }

    private fun createMockResponse(): QuoteResponse {
        return QuoteResponse(
            count = 10, totalCount = 100, page = 1, totalPages = 5, lastItemIndex = 10, emptyList()
        )
    }
}