package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag

/**
 * QuoteRepository.kt
 *
 * This class is for handling data operations.
 *
 * @param dao
 * @author Taji Abdullah
 * */
class QuoteRepository(private val dao: QuoteDao) {
    /**
     * Insert a [QuoteEntity] into the database.
     * */
    suspend fun insertQuote(quoteEntity: QuoteEntity) = dao.insertQuote(quoteEntity)

    /**
     * Insert a [Tag] into the database.
     * */
    suspend fun insertTag(tag: Tag) = dao.insertTag(tag)

    /**
     * Insert a [Author] into the database.
     * */
    suspend fun insertAuthor(author: Author) = dao.insertAuthor(author)

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(dao: QuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(dao).also { instance = it }
            }
    }
}
