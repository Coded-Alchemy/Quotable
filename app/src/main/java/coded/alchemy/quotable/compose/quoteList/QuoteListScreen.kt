package coded.alchemy.quotable.compose.quoteList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.quotable.compose.QuotableAppbar
import coded.alchemy.quotable.compose.QuotableBottomNavigation
import coded.alchemy.quotable.ui.theme.QuotableTheme
import coded.alchemy.quotable.viewModel.QuoteListViewModel

const val TAG = "QuoteListScreen"

@Composable
fun QuoteListScreen(viewModel: QuoteListViewModel = hiltViewModel(), navHostController: NavHostController = rememberNavController()) {
    val articleList = viewModel.getQuoteFlow().collectAsLazyPagingItems()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffolding(articleList, navHostController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffolding(articleList: LazyPagingItems<Quote>, navHostController: NavHostController) {
    var presses by remember { mutableIntStateOf(0) }
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            QuotableAppbar()
        },
        bottomBar = {
            QuotableBottomNavigation(navHostController)
        }
//        floatingActionButton = {
//            FloatingActionButton(onClick = { presses++ }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            QuoteList(articleList)
        }
    }
}

/**
 * Display a list of quotes.
 * */
@Composable
fun QuoteList(articleList: LazyPagingItems<Quote>) {
    LazyColumn {
        items(
            count = articleList.itemCount
        ) { index ->
            val article = articleList[index]
            article?.let { item ->
                QuoteListItem(item)
            }
        }
    }
}

/**
 * Display a single quote in the list.
 * */
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotableTheme {
        QuoteListScreen()
    }
}
