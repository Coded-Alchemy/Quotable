package coded.alchemy.quotable.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotableApi {
    @GET("quotes")
    suspend fun getQuotes(
        @Query("page") page: Int,
    ): QuoteResponse

    companion object {
        private const val BASE_URL = "https://api.quotable.io/"

        fun create(): QuotableApi {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client =
                OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuotableApi::class.java)
        }
    }
}
