package coded.alchemy.qoutable.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import kotlinx.coroutines.flow.Flow

/**
 * RemoteKeyDao.kt
 *
 * This interface provides [Author] database functionality.
 *
 * @author Taji Abdullah
 */
@Dao
interface AuthorDao {

    /**
     * Add a [Author] to the database.
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthor(vararg author: Author)

    /**
     * Retrieve a [Author] from the database.
     * */
    @Query("SELECT * FROM author WHERE name = :name")
    suspend fun getAuthorByName(name: String): Author

    /**
     * Retrieve all [Author] from the database.
     * */
    @Query("SELECT * FROM author")
    fun getAllAuthors(): Flow<List<Author>>

    @Query(
        "SELECT * FROM author " +
            "JOIN quoteEntity ON author.name = quoteEntity.author " +
            "WHERE author.name = :name"
    )
    fun getAuthorWithQuotes(name: String): Map<Author, List<QuoteEntity>>

    @Query("DELETE FROM author")
    suspend fun deleteAll(): Int
}
