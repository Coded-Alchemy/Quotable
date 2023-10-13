package coded.alchemy.quotable.network

import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Unit tests for the [QuotableApi] class.
 *
 * These tests use MockWebServer to mock the server responses.
 *
 * @author Taji Abdullah
 */
class QuotableApiUnitTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var quotableApi: QuotableApi

    @Before
    fun setup() {
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
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testGetQuotes() =
        runBlocking {
            // Mock the server response
            val responseBody =
                """
                {
                    "count": 2,
                    "totalCount": 2,
                    "page": 1,
                    "totalPages": 1,
                    "lastItemIndex": 2,
                    "results": [
                        {
                            "_id": "1",
                            "author": "Author 1",
                            "content": "QuoteEntity 1",
                            "tags": [],
                            "authorSlug": "author-1",
                            "length": 42,
                            "dateAdded": "2023-09-21",
                            "dateModified": "2023-09-21"
                        },
                        {
                            "_id": "2",
                            "author": "Author 2",
                            "content": "QuoteEntity 2",
                            "tags": ["Tag1", "Tag2"],
                            "authorSlug": "author-2",
                            "length": 55,
                            "dateAdded": "2023-09-22",
                            "dateModified": "2023-09-22"
                        }
                    ]
                }
                """.trimIndent()

            mockWebServer.enqueue(MockResponse().setBody(responseBody))

            // Make the API call
            val response = quotableApi.getQuotes(1)

            // Verify the response
            assertNotNull(response)
            assert(response.results.size == 2)
            // Add more assertions as needed to verify the response data
        }
}
