package coded.alchemy.quotable.ui.authorList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.quotable.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthorListScreen(
    onAuthorClick: (String) -> Unit,
    viewModel: AuthorListViewModel = koinViewModel()
) {
    val authors by viewModel.authors.collectAsState(emptyList())
    val loading by viewModel.loading.collectAsState(false)
    val error by viewModel.error.collectAsState(null)

    LaunchedEffect(viewModel) {
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AuthorList(authors = authors, onAuthorClick = onAuthorClick)
    }
}

/**
 * Display a list of [Author] objects.
 * @param authors the list of [Author] objects to populate the list.
 * @param onAuthorClick callback to hoist up the selected [Author] in the [Composable] hierarchy.
 * */
@Composable
fun AuthorList(
    authors: List<Author>,
    onAuthorClick: (String) -> Unit
) {
    LazyColumn {
        items(authors) { author ->
            TagListItem(author, onAuthorClick)
        }
    }
}

/**
 * Display a single [Author] in the list.
 * @param author the object to be displayed in the list.
 * @param selectedAuthor callback to hoist up the selected [Author] in the [Composable] hierarchy.
 * */
@Composable
fun TagListItem(
    author: Author,
    selectedAuthor: (String) -> Unit
) {
    Card(
        modifier =
        Modifier
            .padding(all = dimensionResource(id = R.dimen.default_padding))
            .fillMaxWidth()
            .clickable(onClick = { selectedAuthor(author.name) }),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        )
    ) {
        Column(modifier = Modifier.padding(all = dimensionResource(id = R.dimen.default_padding))) {
            Text(
                author.name,
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.default_padding))
            )
        }
    }
}
