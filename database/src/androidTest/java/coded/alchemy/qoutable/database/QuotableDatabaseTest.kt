package coded.alchemy.qoutable.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.AuthorWithTaggedQuotes
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.QuoteWithTags
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
                    date_added = null,
                    date_modified = null
                )
            dao.insertQuote(quoteEntity)

            // Test the stored QuoteEntity object is the same as expected.
            val storedQuote = dao.getQuoteById(id.toLong())
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
    fun storeStuff() =
        runBlocking {
            val authorId = 55L
            val author = Author(authorId = authorId, name = "Test Driven", slug = "test_driven")

            // Quotes
            val quoteEntity1 =
                QuoteEntity(
                    quoteId = "55",
                    authorId = authorId,
//            author = "Author 1",
                    content = "Content 1",
//            tags = listOf("Tag1", "Tag2"),
                    author_slug = "author1-slug",
                    length = 100,
                    date_added = "2023-09-21",
                    date_modified = "2023-09-21"
                )
            val quoteEntity2 =
                QuoteEntity(
                    quoteId = "56",
                    authorId = authorId,
//            author = "Author 2",
                    content = "Content 2",
//            tags = listOf("Tag3", "Tag4"),
                    author_slug = "author2-slug",
                    length = 200,
                    date_added = "2023-09-22",
                    date_modified = "2023-09-22"
                )

            // Tags
            val tag1 = Tag(tagId = 1, content = "TestTag1", quoteId = "56")
            val tag2 = Tag(tagId = 2, content = "TestTag2", quoteId = "57")
            val tagList = listOf(tag1, tag2)

            val quoteWithTags1 = QuoteWithTags(quoteEntity1, tagList)
            val quoteWithTags2 = QuoteWithTags(quoteEntity2, tagList)
            val quoteWithTagsList = listOf(quoteWithTags1, quoteWithTags2)

            val authorWithTaggedQuotes = AuthorWithTaggedQuotes(author = author, quoteWithTagsList)

            val storedAuthor = dao.getAuthorById(55)

            assertThat(storedAuthor, equalTo(author))
        }
}
