package coded.alchemy.qoutable.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Quote
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DataBaseTest {
    private lateinit var dao: QuoteDao
    private lateinit var db: QuotableDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, QuotableDatabase::class.java).build()
        dao = db.quoteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeQuoteAndReadInList() = runBlocking {
        val quote = Quote(
            quoteId = 234,
            authorId = 345,
            content = "yo yo yo",
            length = null,
            date_added = null,
            date_modified = null
        )
        dao.insertQuote(quote)
        val storedQuote = dao.loadQuoteId(234)
        assertThat(storedQuote, equalTo(quote))
    }
}