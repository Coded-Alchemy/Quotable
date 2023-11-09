package coded.alchemy.quotable.ui.tagList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coded.alchemy.qoutable.database.data.Tag
import coded.alchemy.quotable.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun TagListScreen(
    onTagClick: (String) -> Unit,
    viewModel: TagListViewModel = koinViewModel()
) {
    val tagList by viewModel.tags.collectAsState(emptyList())
    val loading by viewModel.loading.collectAsState(false)
    val error by viewModel.error.collectAsState(null)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        TagList(tagList = tagList, onTagClick = onTagClick)
    }
}

@Composable
fun TagList(
    tagList: List<Tag>,
    onTagClick: (String) -> Unit
) {
    LazyColumn {
        items(tagList) { tag ->
            TagListItem(tag, onTagClick)
        }
    }
}

@Composable
fun TagListItem(
    tag: Tag,
    selectedTag: (String) -> Unit
) {
    Card(
        modifier =
        Modifier
            .padding(all = dimensionResource(id = R.dimen.default_padding))
            .fillMaxWidth()
            .clickable(onClick = { selectedTag(tag.content) })
    ) {
        Column(modifier = Modifier.padding(all = dimensionResource(id = R.dimen.default_padding))) {
            Text(
                tag.content,
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.default_padding))
            )
        }
    }
}
