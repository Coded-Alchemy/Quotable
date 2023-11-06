package coded.alchemy.qoutable.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coded.alchemy.qoutable.database.data.QuoteEntity

/**
 * RemoteKeyDao.kt
 *
 * This interface provides [QuoteEntity] database functionality.
 *
 * @author Taji Abdullah
 */
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
    suspend fun getQuoteById(id: String): QuoteEntity

    @Query("SELECT * FROM quoteEntity")
    suspend fun getQuotes(): List<QuoteEntity>

    @Query("DELETE FROM quoteEntity")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM quoteEntity")
    fun pagingSource(): PagingSource<Int, QuoteEntity>

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
