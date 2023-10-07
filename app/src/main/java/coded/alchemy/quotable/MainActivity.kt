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
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag
import coded.alchemy.quotable.ui.theme.QuotableTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val logTag = this::class.java.simpleName
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database =
            Room.databaseBuilder(
                applicationContext,
                QuotableDatabase::class.java,
                QuotableDatabase::class.java.simpleName
            ).build()

//        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
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

                viewModel.storeQuote(dao = database.quoteDao(), quoteEntity = quoteEntity)
                viewModel.storeAuthor(dao = database.quoteDao(), author = author)

                for (content in quote.tags) {
                    viewModel.storeTag(
                        dao = database.quoteDao(),
                        tag = Tag(tagId = null, quoteId = quote._id, content = content)
                    )
                }
            }
        }

        setContent {
            QuotableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(getString(R.string.app_name))
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotableTheme {
        Greeting("Android")
    }
}
