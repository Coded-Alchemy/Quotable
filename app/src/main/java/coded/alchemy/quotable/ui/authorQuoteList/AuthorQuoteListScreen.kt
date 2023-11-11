package coded.alchemy.quotable.ui.authorQuoteList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.ui.app.QuotableProgress
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthorQuoteListScreen(
    authorId: String,
    viewModel: AuthorQuoteListViewModel = koinViewModel(),
    navigateUp: () -> Unit
) {
    val authorName by rememberUpdatedState(newValue = authorId)
    val screenState by viewModel.getAuthorWithQuotes(authorName)
            .collectAsState(initial = AuthorWithQuotesState.Loading)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            when (screenState) {
                is AuthorWithQuotesState.Loading -> QuotableProgress()
                is AuthorWithQuotesState.Success -> displayInfo(authorName, screenState, navigateUp)
                is AuthorWithQuotesState.Error -> {
                    // Error state
                    val errorMessage = (screenState as AuthorWithQuotesState.Error).message
                    // Display or handle the error message
                }
            }
        }
    }
}

@Composable
fun displayInfo(authorName: String, state: AuthorWithQuotesState, navigateUp: () -> Unit) {
    IconButton(onClick = navigateUp) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = null
        )
    }

    val authorWithQuotes = (state as AuthorWithQuotesState.Success).data
    val foundAuthorEntry: Map.Entry<Author, List<QuoteEntity>>? =
        authorWithQuotes.entries.find { it.key.name == authorName }

    foundAuthorEntry?.key?.name?.let {
        Text(
            text = it /*?: "Loading Text"*/,
            fontSize = 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(10.dp)
        )
    }
}
