package coded.alchemy.qoutable.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag

@Dao
interface QuoteDao {

    /**
     * Add a [QuoteEntity] to the database.
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(vararg quoteEntity: QuoteEntity)

    /**
     * Retrieve a [QuoteEntity] from the database.
     * */
    @Query("SELECT * FROM quoteEntity WHERE quoteId = :id")
    suspend fun getQuoteById(id: Long): QuoteEntity

    @Query("SELECT * FROM quoteEntity")
    suspend fun getQuotes(): List<QuoteEntity>

    /**
     * Add a [Tag] to the database.
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTag(vararg tag: Tag)

    /**
     * Retrieve a [Tag] from the database.
     * */
    @Query("SELECT * FROM tag WHERE tagId = :id")
    suspend fun getTagById(id: Long): Tag

    /**
     * Add a [Author] to the database.
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthor(vararg author: Author)

    /**
     * Retrieve a [Author] from the database.
     * */
    @Query("SELECT * FROM author WHERE authorId = :id")
    suspend fun getAuthorById(id: Long): Author


//    @Transaction
//    @Query("SELECT * FROM QuoteEntity")
//    suspend fun getUsersWithPlaylistsAndSongs(): List<QuoteWithTags>

//    @Update
//    suspend fun updateQuotes(vararg quoteEntities: QuoteEntity)
//
//    @Delete
//    suspend fun delete(vararg quoteEntities: QuoteEntity)
//
//    @Query("SELECT * FROM quoteEntity")
//    suspend fun getAll(): List<QuoteEntity>
//
//    @Query("SELECT * FROM quoteEntity WHERE uid IN (:quoteIds)")
//    suspend fun loadAllByIds(quoteIds: IntArray): List<QuoteEntity>
//
//    @Query("SELECT * FROM quoteEntity WHERE author LIKE :author")
//    suspend fun findByAuthor(author: String): List<QuoteEntity>
}