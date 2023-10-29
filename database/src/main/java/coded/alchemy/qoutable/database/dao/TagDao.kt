package coded.alchemy.qoutable.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coded.alchemy.qoutable.database.data.Tag

/**
 * RemoteKeyDao.kt
 *
 * This interface provides [Tag] database functionality.
 *
 * @author Taji Abdullah
 */
@Dao
interface TagDao {

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
}