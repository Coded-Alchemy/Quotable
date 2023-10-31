package coded.alchemy.quotable.data

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

    suspend fun insert(remoteKey: RemoteKey) = remoteKeyDao.insertOrReplace(remoteKey)

    suspend fun query(query: String) = remoteKeyDao.remoteKeyByQuery(query = query)

    suspend fun delete(query: String) = remoteKeyDao.deleteByQuery(query = query)

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
