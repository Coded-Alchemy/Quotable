package coded.alchemy.quotable.data

import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag
import javax.inject.Inject
import javax.inject.Singleton

/**
 * QuoteRepository.kt
 *
 * This class is for handling data operations.
 *
 * @param dao
 * @author Taji Abdullah
 * */
@Singleton
class QuoteRepository @Inject constructor() : QuoteDao {
    /**
     * Insert a [QuoteEntity] into the database.
     * */
//    suspend fun insertQuote(quoteEntity: QuoteEntity) = dao.insertQuote(quoteEntity)

//    suspend fun getQuotes() = dao.getQuotes()

    /**
     * Insert a [Tag] into the database.
     * */
//    suspend fun insertTag(tag: Tag) = dao.insertTag(tag)

    /**
     * Insert a [Author] into the database.
     * */
//    suspend fun insertAuthor(author: Author) = dao.insertAuthor(author)

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository().also { instance = it }
            }
    }

    override suspend fun insertQuote(vararg quoteEntity: QuoteEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getQuoteById(id: String): QuoteEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getQuotes(): List<QuoteEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTag(vararg tag: Tag) {
        TODO("Not yet implemented")
    }

    override suspend fun getTagById(id: Long): Tag {
        TODO("Not yet implemented")
    }

    override suspend fun insertAuthor(vararg author: Author) {
        TODO("Not yet implemented")
    }

    override suspend fun getAuthorById(id: Long): Author {
        TODO("Not yet implemented")
    }
}
