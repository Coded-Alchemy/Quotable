package coded.alchemy.quotable.compose.quoteDetail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import coded.alchemy.quotable.viewModel.QuoteListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun QuoteDetailScreen(
    viewModel: QuoteListViewModel = koinViewModel(),
    quoteId: String,
    navigateUp: () -> Unit
) {
    IconButton(onClick = navigateUp) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = null
        )
    }
}
