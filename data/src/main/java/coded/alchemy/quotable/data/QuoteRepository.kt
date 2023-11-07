package coded.alchemy.quotable.data

import android.util.Log
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
        quoteDao.insertQuote(quoteEntity)
    }

    suspend fun getQuote(quoteId: String): QuoteEntity {
        return quoteDao.getQuoteById(quoteId)
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
