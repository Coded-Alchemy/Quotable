package coded.alchemy.quotable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import androidx.room.RoomDatabase
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag
import coded.alchemy.quotable.compose.QuotableApp
import coded.alchemy.quotable.ui.theme.QuotableTheme
import coded.alchemy.quotable.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val logTag = this::class.java.simpleName
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var list: MutableList<QuoteEntity>
    private lateinit var database: QuotableDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(logTag, "onCreate: ")
        initialization()
        storeData((database).quoteDao())
    }

    override fun onStart() {
        super.onStart()
        Log.i(logTag, "onStart: ")
        viewModel.getQuotes(database.quoteDao())
        viewModel.quoteList.observe(this) { quoteList ->
            Log.d(logTag, "Observe quote: $quoteList")
            for (quote in quoteList) {
                list.add(quote)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i(logTag, "onResume: ")
        setContent {
            QuotableTheme {
                QuotableApp(viewModel)
            }
        }
    }

    private fun initialization() {
        database =
            Room.databaseBuilder(
                applicationContext,
                QuotableDatabase::class.java,
                QuotableDatabase::class.java.simpleName,
            ).build()

//        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        list = mutableListOf()
    }

    private fun storeData(dao: QuoteDao) {
        viewModel.getQuoteResponse()

        viewModel.quoteResponse.observe(this) { response ->
            Log.d(logTag, response.toString())

            for (quote in response.results) {
                val quoteEntity =
                    QuoteEntity(
                        quoteId = quote._id,
                        authorId = null,
                        content = quote.content,
                        author_slug = quote.authorSlug,
                        length = quote.length.toLong(),
                        date_added = quote.dateAdded,
                        date_modified = quote.dateModified
                    )

                val author = Author(name = quote.author, slug = quote.authorSlug, authorId = null)

                viewModel.storeQuote(dao = dao, quoteEntity = quoteEntity)
                viewModel.storeAuthor(dao = dao, author = author)

                for (content in quote.tags) {
                    viewModel.storeTag(
                        dao = dao,
                        tag = Tag(tagId = null, quoteId = quote._id, content = content)
                    )
                }
            }
        }
    }
}