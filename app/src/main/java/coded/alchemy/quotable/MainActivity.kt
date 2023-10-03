package coded.alchemy.quotable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.quotable.data.QuoteRepository
import coded.alchemy.quotable.ui.theme.QuotableTheme

class MainActivity : ComponentActivity() {
    private val logTag = this::class.java.simpleName
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(
            applicationContext,
            QuotableDatabase::class.java, QuotableDatabase::class.java.simpleName
        ).build()

        val quoteList = mutableListOf<Quote>()

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getQuoteResponse()
        viewModel.quoteResponse.observe(this) { response ->
            for (quote in response.results) {
                Log.d(logTag, quote._id)
                Log.d(logTag, quote.content)

                QuoteRepository.getInstance(database.quoteDao()).insertQuote(quote)



                quoteList.add(quote)
            }
        }


//        Log.d(logTag, database.quoteDao().getAll().toString())






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
fun Greeting(name: String, modifier: Modifier = Modifier) {
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