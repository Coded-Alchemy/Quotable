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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuthorQuoteListScreen(
    authorId: String,
    navigateUp: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {

            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null
                )
            }

            Text(
                text = authorId /*?: "Loading Text"*/,
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
