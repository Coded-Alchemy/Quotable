package coded.alchemy.qoutable.database

import androidx.room.Database
import androidx.room.RoomDatabase
import coded.alchemy.qoutable.database.data.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuotableDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}