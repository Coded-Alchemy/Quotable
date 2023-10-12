package coded.alchemy.quotable.compose.quoteList

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.ui.theme.QuotableTheme
import coded.alchemy.quotable.viewModel.QuoteListViewModel

const val TAG = "QuoteListScreen"
@Composable
fun QuoteListScreen(viewModel: QuoteListViewModel) {
    val articleList = viewModel.getFlow().collectAsLazyPagingItems()

    Log.d(TAG, "QuoteListScreen: $articleList")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting(name = viewModel.testInfo)
        QuoteList(articleList = articleList)
    }
}

@Composable
fun QuoteList(articleList: LazyPagingItems<Quote>) {
    LazyColumn{
        items(
            count = articleList.itemCount,
        ) { index ->
            val article = articleList[index]
            article?.let { item ->
                QuoteListItem(item)
//                NewsArticle(
//                    modifier = Modifier.fillMaxWidth().padding(8.dp),
//                    article = item
//                )
            }
        }
    }


//    LazyColumn(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        articleList.forEach { quoteEntity ->
//            QuoteListItem(quoteEntity)
//        }
//    }
}

@Composable
fun QuoteListItem(quoteEntity: Quote) {
    Card(
        modifier =
        Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(quoteEntity.content, fontSize = 25.sp, color = Color.Black, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp))
            quoteEntity.author?.let { Text(it, color = Color.Gray, modifier = Modifier.padding(10.dp)) }
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
