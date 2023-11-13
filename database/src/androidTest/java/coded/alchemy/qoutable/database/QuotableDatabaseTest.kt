package coded.alchemy.qoutable.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.dao.AuthorDao
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.dao.TagDao
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
    private lateinit var quoteDao: QuoteDao
    private lateinit var tagDao: TagDao
    private lateinit var authorDao: AuthorDao
    private lateinit var database: QuotableDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database =
            Room.inMemoryDatabaseBuilder(
                context,
                QuotableDatabase::class.java
            ).build()
        quoteDao = database.quoteDao()
        tagDao = database.tagDao()
        authorDao = database.authorDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
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
                    content = "yo yo yo",
                    author_slug = "author1-slug",
                    length = 45,
                    date_added = "10/23/1970",
                    date_modified = "12/05/2025"
                )
            quoteDao.insertQuote(quoteEntity)

            // Test the stored QuoteEntity object is the same as expected.
            val storedQuote = quoteDao.getQuoteById(id)
            assertThat(storedQuote, equalTo(quoteEntity))
        }

    /**
     * Test [Tag] storage in the database.
     * */
    @Test
    @Throws(Exception::class)
    fun storeTag() =
        runBlocking {
            val id = "TestTag"

            // Create a Tag object and store it in the database.
            val tag = Tag(content = "TestTag", quoteId = "45654")
            tagDao.insertTag(tag)

            // Test the stored Tag object is the same as expected.
            val storedTag = tagDao.getTagById(id)
            assertThat(storedTag, equalTo(tag))
        }

    /**
     * Test [Author] storage in the database.
     * */
    @Test
    @Throws(Exception::class)
    fun storeAuthor() =
        runBlocking {
            val id = "Test Driven"

            // Create a Tag object and store it in the database.
            val author = Author(name = "Test Driven", slug = "test_driven")
            authorDao.insertAuthor(author)

            // Test the stored Tag object is the same as expected.
            val storedAuthor = authorDao.getAuthorByName(id)
            assertThat(storedAuthor, equalTo(author))
        }

    @Test
    @Throws(Exception::class)
    fun getQuotes() =
        runBlocking {
            val list = quoteDao.getQuotes()

            Assert.assertNotNull(list)
            Assert.assertNotNull(list.isNotEmpty())
        }
}
