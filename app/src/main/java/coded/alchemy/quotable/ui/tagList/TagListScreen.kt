package coded.alchemy.quotable.ui.tagList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import coded.alchemy.quotable.ui.quoteList.QuoteList
import coded.alchemy.quotable.ui.quoteList.QuoteListViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun TagListScreen(
    onTagClick: (String) -> Unit,
    viewModel: QuoteListViewModel = koinViewModel()
) {
    val quoteList = viewModel.getPagingQuoteFlow(koinInject()).collectAsLazyPagingItems()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        QuoteList(articleList = quoteList, onQuoteClick = onTagClick)
    }
}