package coded.alchemy.quotable.data

import android.util.Log
import coded.alchemy.qoutable.database.dao.RemoteKeyDao
import coded.alchemy.qoutable.database.data.RemoteKey
import javax.inject.Inject
import javax.inject.Singleton

/**
 * RemoteKeyRepository.kt
 *
 * This class is for handling data operations for remote keys.
 *
 * @param remoteKeyDao
 * @author Taji Abdullah
 * */
@Singleton
class RemoteKeyRepository @Inject constructor(private val remoteKeyDao: RemoteKeyDao) {
    private val TAG = this.javaClass.simpleName

    suspend fun insert(remoteKey: RemoteKey) {
        Log.d(TAG, "insert: $remoteKey")
        remoteKeyDao.insertOrReplace(remoteKey)
    }

    suspend fun getKey(): RemoteKey? {
        Log.d(TAG, "getKey: ")
        return remoteKeyDao.get()
    }

    suspend fun delete() {
        Log.d(TAG, "deleteAll: ")
        remoteKeyDao.deleteAll()
    }

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: RemoteKeyRepository? = null

        fun getInstance(remoteKeyDao: RemoteKeyDao) =
            instance ?: synchronized(this) {
                instance ?: RemoteKeyRepository(remoteKeyDao).also { dao -> instance = dao }
            }
    }
}
