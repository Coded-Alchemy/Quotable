package coded.alchemy.quotable.data

import android.util.Log
import coded.alchemy.qoutable.database.dao.TagDao
import coded.alchemy.qoutable.database.data.Tag
import javax.inject.Inject
import javax.inject.Singleton

/**
 * TagRepository.kt
 *
 * This class is for handling data operations for [Tag].
 *
 * @param tagDao
 * @author Taji Abdullah
 * */
@Singleton
class TagRepository @Inject constructor(private val tagDao: TagDao) {
    private val TAG = this.javaClass.simpleName

    /**
     * Insert a [Tag] into the database.
     * */
    suspend fun insertTag(tag: Tag) {
        Log.d(TAG, "insertTag: $tag")
        tagDao.insertTag(tag)
    }

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: TagRepository? = null

        fun getInstance(tagDao: TagDao) =
            instance ?: synchronized(this) {
                instance ?: TagRepository(tagDao).also { dao -> instance = dao }
            }
    }
}
