package coded.alchemy.qoutable.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.QuoteWithTags
import coded.alchemy.qoutable.database.data.Tag

@Dao
interface QuoteDao {

    /**
     * Add a [Quote] to the database.
     * */
    @Insert
    suspend fun insertQuote(vararg quote: Quote)

    /**
     * Retrieve a [Quote] from the database.
     * */
    @Query("SELECT * FROM quote WHERE quoteId = :id")
    suspend fun getQuoteById(id: Long): Quote

    /**
     * Add a [Tag] to the database.
     * */
    @Insert
    suspend fun insertTag(vararg tag: Tag)

    /**
     * Retrieve a [Tag] from the database.
     * */
    @Query("SELECT * FROM tag WHERE tagId = :id")
    suspend fun getTagById(id: Long): Tag

    /**
     * Add a [Author] to the database.
     * */
    @Insert
    suspend fun insertAuthor(vararg author: Author)

    /**
     * Retrieve a [Author] from the database.
     * */
    @Query("SELECT * FROM author WHERE authorId = :id")
    suspend fun getAuthorById(id: Long): Author

//    @Transaction
//    @Query("SELECT * FROM Quote")
//    suspend fun getUsersWithPlaylistsAndSongs(): List<QuoteWithTags>

//    @Update
//    suspend fun updateQuotes(vararg quotes: Quote)
//
//    @Delete
//    suspend fun delete(vararg quotes: Quote)
//
//    @Query("SELECT * FROM quote")
//    suspend fun getAll(): List<Quote>
//
//    @Query("SELECT * FROM quote WHERE uid IN (:quoteIds)")
//    suspend fun loadAllByIds(quoteIds: IntArray): List<Quote>
//
//    @Query("SELECT * FROM quote WHERE author LIKE :author")
//    suspend fun findByAuthor(author: String): List<Quote>
}