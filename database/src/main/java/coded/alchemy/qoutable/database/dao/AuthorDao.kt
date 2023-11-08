package coded.alchemy.qoutable.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coded.alchemy.qoutable.database.data.Author
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
    @Query("SELECT * FROM author WHERE authorId = :id")
    suspend fun getAuthorById(id: Long): Author

    /**
     * Retrieve all [Author] from the database.
     * */
    @Query("SELECT * FROM author")
    fun getAllAuthors(): Flow<List<Author>>

    @Query("DELETE FROM author")
    suspend fun deleteAll(): Int
}
