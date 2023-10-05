package coded.alchemy.quotable.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.compose.quoteList.QuoteListScreen

@Composable
fun QuotableApp(quoteEntities: List<QuoteEntity>) {
    val navController = rememberNavController()
    QuotableNavHost(navController = navController, quoteEntities = quoteEntities)
}

@Composable
fun QuotableNavHost(
    navController: NavHostController,
    quoteEntities: List<QuoteEntity>
) {
    val quoteListScreen = "quoteListScreen"

    NavHost(navController = navController, startDestination = quoteListScreen) {
        composable(quoteListScreen) {
            QuoteListScreen(quoteEntities)
        }
    }
}
