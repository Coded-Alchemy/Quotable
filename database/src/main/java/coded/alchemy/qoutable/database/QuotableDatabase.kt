package coded.alchemy.qoutable.database

import androidx.room.Database
import androidx.room.RoomDatabase
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.dao.RemoteKeyDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.RemoteKey
import coded.alchemy.qoutable.database.data.Tag

/**
 * QuotableDatabase.kt
 *
 * Representation of the database used in this app.
 *
 * @author Taji Abdullah
 */
@Database(entities = [QuoteEntity::class, Tag::class, Author::class, RemoteKey::class], version = 1)
abstract class QuotableDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}
