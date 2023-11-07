package coded.alchemy.qoutable.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coded.alchemy.qoutable.database.data.RemoteKey
import kotlinx.coroutines.flow.Flow

/**
 * RemoteKeyDao.kt
 *
 * This interface provides [RemoteKey] database functionality.
 *
 * @author Taji Abdullah
 */
@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(remoteKey: RemoteKey)

    @Query("SELECT * FROM remote_keys LIMIT 1")
    suspend fun get(): RemoteKey?

    @Query("DELETE FROM remote_keys")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM remote_keys LIMIT 1")
    fun getKeyFlow(): Flow<RemoteKey?>
}
