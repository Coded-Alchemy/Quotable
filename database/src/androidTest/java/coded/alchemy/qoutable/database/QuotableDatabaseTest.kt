package coded.alchemy.qoutable.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.Tag
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class QuotableDatabaseTest {
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

    /**
     * Test [Quote] storage in the database.
     * */
    @Test
    @Throws(Exception::class)
    fun storeQuote() = runBlocking {
        val id = 234L

        // Create a Quote object and store it in the database.
        val quote = Quote(
            quoteId = id,
            authorId = 345,
            content = "yo yo yo",
            length = null,
            date_added = null,
            date_modified = null
        )
        dao.insertQuote(quote)

        // Test the stored Quote object is the same as expected.
        val storedQuote = dao.getQuoteById(id)
        assertThat(storedQuote, equalTo(quote))
    }

    /**
     * Test [Tag] storage in the database.
     * */
    @Test
    @Throws(Exception::class)
    fun storeTag() = runBlocking {
        val id = 546L

        // Create a Tag object and store it in the database.
        val tag = Tag(tagId = id, name = "TestTag")
        dao.insertTag(tag)

        // Test the stored Tag object is the same as expected.
        val storedTag = dao.getTagById(id)
        assertThat(storedTag, equalTo(tag))
    }

    /**
     * Test [Author] storage in the database.
     * */
    @Test
    @Throws(Exception::class)
    fun storeAuthor() = runBlocking {
        val id = 432L

        // Create a Tag object and store it in the database.
        val author = Author(authorId = id, name = "Test Driven", slug = "test_driven")
        dao.insertAuthor(author)

        // Test the stored Tag object is the same as expected.
        val storedAuthor = dao.getAuthorById(id)
        assertThat(storedAuthor, equalTo(author))
    }
}