package coded.alchemy.quotable.compose.quoteDetail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import coded.alchemy.quotable.viewModel.QuoteListViewModel

@Composable
fun QuoteDetailScreen(
    viewModel: QuoteListViewModel = hiltViewModel(),
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
