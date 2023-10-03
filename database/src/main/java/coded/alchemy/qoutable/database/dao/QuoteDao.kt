package coded.alchemy.qoutable.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.QuoteWithTags
import coded.alchemy.qoutable.database.data.Tag

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuote(vararg quote: Quote)

    @Query("SELECT * FROM quote WHERE quoteId = :id")
    fun getQuoteById(id: Int): Quote

    @Insert
    suspend fun insertTag(vararg tag: Tag)

    @Transaction
    @Query("SELECT * FROM Quote")
    suspend fun getUsersWithPlaylistsAndSongs(): List<QuoteWithTags>

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