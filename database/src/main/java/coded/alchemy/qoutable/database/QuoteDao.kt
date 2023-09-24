package coded.alchemy.qoutable.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Insert
    fun insertAll(vararg quotes: Quote)

    @Delete
    fun delete(quote: Quote)
    @Query("SELECT * FROM quote")
    fun getAll(): List<Quote>

    @Query("SELECT * FROM quote WHERE uid IN (:quoteIds)")
    fun loadAllByIds(quoteIds: IntArray): List<Quote>

    @Query("SELECT * FROM quote WHERE author LIKE :author")
    fun findByAuthor(author: String): List<Quote>
}