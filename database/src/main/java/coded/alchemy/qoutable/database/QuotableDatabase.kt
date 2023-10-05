package coded.alchemy.qoutable.database

import androidx.room.Database
import androidx.room.RoomDatabase
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag

@Database(entities = [QuoteEntity::class, Tag::class, Author::class], version = 1)
abstract class QuotableDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}
