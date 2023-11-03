package coded.alchemy.quotable.compose.quoteList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import coded.alchemy.quotable.ui.theme.QuotableTheme
import coded.alchemy.quotable.viewModel.QuoteListViewModel
import org.koin.androidx.compose.koinViewModel

const val TAG = "QuoteListScreen"

@Composable
fun QuoteListScreen(
    onQuoteClick: (String) -> Unit,
    viewModel: QuoteListViewModel = koinViewModel()
) {
    val articleList = viewModel.getQuoteFlow().collectAsLazyPagingItems()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        QuoteList(articleList = articleList, onQuoteClick = onQuoteClick)
    }
}

/**
 * Display a list of quotes.
 * */
@Composable
fun QuoteList(
    articleList: LazyPagingItems<Quote>,
    onQuoteClick: (String) -> Unit
) {
    LazyColumn {
        items(
            count = articleList.itemCount
        ) { index ->
            val article = articleList[index]
            article?.let { item ->
                QuoteListItem(item, onQuoteClick)
            }
        }
    }
}

/**
 * Display a single quote in the list.
 * */
@Composable
fun QuoteListItem(
    quoteEntity: Quote,
    selectedQuote: (String) -> Unit
) {
    Card(
        modifier =
        Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
            .clickable(onClick = { selectedQuote(quoteEntity._id) })
    ) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(
                quoteEntity.content,
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(10.dp)
            )
            quoteEntity.author?.let {
                Text(
                    it,
                    color = Color.Gray,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotableTheme {
//        QuoteListScreen()
    }
}
