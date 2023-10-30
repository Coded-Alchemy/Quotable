package coded.alchemy.qoutable.database

import androidx.room.Database
import androidx.room.RoomDatabase
import coded.alchemy.qoutable.database.dao.AuthorDao
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.dao.RemoteKeyDao
import coded.alchemy.qoutable.database.dao.TagDao
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
    abstract fun tagDao(): TagDao
    abstract fun authorDao(): AuthorDao
    abstract fun remoteKeyDao(): RemoteKeyDao
}
