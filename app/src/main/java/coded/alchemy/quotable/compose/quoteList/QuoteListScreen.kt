package coded.alchemy.quotable.compose.quoteList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.ui.theme.QuotableTheme

@Composable
fun QuoteListScreen(quoteEntities: List<QuoteEntity>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        QuoteList(quoteEntities)
    }
}

@Composable
fun QuoteList(quoteEntities: List<QuoteEntity>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        quoteEntities.forEach { quoteEntity ->
            QuoteListItem(quoteEntity)
        }
    }
}

@Composable
fun QuoteListItem(quoteEntity: QuoteEntity) {
    Card(
        modifier =
            Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(quoteEntity.content, fontSize = 25.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp))
//            Text(student.credits.toString(), color = Color.Gray, modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuotableTheme {
        Greeting("Android")
    }
}
