package coded.alchemy.quotable.data

import android.util.Log
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.RemoteMediator
//import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.QuoteEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * QuoteRepository.kt
 *
 * This class is for handling data operations.
 *
 * @param quoteDao
 * @author Taji Abdullah
 * */
@Singleton
class QuoteRepository @Inject constructor(private val quoteDao: QuoteDao) {
    private val TAG = this.javaClass.simpleName

    /**
     * Insert a [QuoteEntity] into the database.
     * */
    suspend fun insertQuote(quoteEntity: QuoteEntity) {
        Log.d(TAG, "insertQuote: $quoteEntity")
        quoteDao.insertQuote(quoteEntity)
    }

    suspend fun getQuote(quoteId: String) {
        Log.d(TAG, "getQuote: $quoteId")
        quoteDao.getQuoteById(quoteId)
    }

    suspend fun getQuotes() {
        Log.d(TAG, "getQuotes: ")
        quoteDao.getQuotes()
    }

    suspend fun deleteQuotes() {
        Log.d(TAG, "deleteQuotes: ")
        quoteDao.deleteAll()
    }

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(dao: QuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(dao).also { instance = it }
            }
    }
}
