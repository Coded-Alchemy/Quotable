package coded.alchemy.qoutable.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * QuotableDatabaseTest.kt
 *
 * Tests for [QuotableDatabase] functionality.
 *
 * @author Taji Abdullah
 */
@RunWith(AndroidJUnit4::class)
class QuotableDatabaseTest {
    private lateinit var dao: QuoteDao
    private lateinit var db: QuotableDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db =
            Room.inMemoryDatabaseBuilder(
                context,
                QuotableDatabase::class.java
            ).build()
        dao = db.quoteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    /**
     * Test [QuoteEntity] storage in the database.
     * */
    @Test
    @Throws(Exception::class)
    fun storeQuote() =
        runBlocking {
            val id = "234L"

            // Create a QuoteEntity object and store it in the database.
            val quoteEntity =
                QuoteEntity(
                    quoteId = id,
                    authorId = 345,
                    content = "yo yo yo",
                    author_slug = "author1-slug",
                    length = 45,
                    date_added = "10/23/1970",
                    date_modified = "12/05/2025"
                )
            dao.insertQuote(quoteEntity)

            // Test the stored QuoteEntity object is the same as expected.
            val storedQuote = dao.getQuoteById(id)
            assertThat(storedQuote, equalTo(quoteEntity))
        }

    /**
     * Test [Tag] storage in the database.
     * */
    @Test
    @Throws(Exception::class)
    fun storeTag() =
        runBlocking {
            val id = 546L

            // Create a Tag object and store it in the database.
            val tag = Tag(tagId = id, content = "TestTag", quoteId = "45654")
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
    fun storeAuthor() =
        runBlocking {
            val id = 432L

            // Create a Tag object and store it in the database.
            val author = Author(authorId = id, name = "Test Driven", slug = "test_driven")
            dao.insertAuthor(author)

            // Test the stored Tag object is the same as expected.
            val storedAuthor = dao.getAuthorById(id)
            assertThat(storedAuthor, equalTo(author))
        }

    @Test
    @Throws(Exception::class)
    fun getQuotes() =
        runBlocking {
            val list = dao.getQuotes()

            Assert.assertNotNull(list)
            Assert.assertNotNull(list.isNotEmpty())
        }
}
