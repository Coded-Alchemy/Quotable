package coded.alchemy.quotable.ui.quoteDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel

@Composable
fun QuoteDetailScreen(
    viewModel: QuoteDetailViewModel = koinViewModel(),
    quoteId: String,
    navigateUp: () -> Unit
) {
    Column {
        viewModel.getQuote(quoteId)
        val quote by viewModel.quote.collectAsState()

        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null
            )
        }

        Text(
            text = quote?.content ?: "Loading Text",
            fontSize = 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(10.dp)
        )
    }
}
