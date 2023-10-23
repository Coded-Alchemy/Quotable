package coded.alchemy.quotable.compose.quoteDetail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coded.alchemy.quotable.viewModel.QuoteDetailViewModel
import coded.alchemy.quotable.viewModel.QuoteListViewModel

@Composable
fun QuoteDetailScreen(
    viewModel: QuoteDetailViewModel = hiltViewModel(),
    quoteId: String,
    navigateUp: () -> Unit
) {
    IconButton(onClick = navigateUp) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = null
        )
    }

    Text(text = quoteId,
        fontSize = 25.sp,
        color = Color.Black,
        fontWeight = FontWeight.W700,
        modifier = Modifier.padding(10.dp))
}
