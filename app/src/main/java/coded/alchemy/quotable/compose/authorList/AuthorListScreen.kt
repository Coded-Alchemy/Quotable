package coded.alchemy.quotable.compose.authorList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coded.alchemy.quotable.viewModel.AuthorListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthorListScreen(viewModel: AuthorListViewModel = koinViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
    }
}
