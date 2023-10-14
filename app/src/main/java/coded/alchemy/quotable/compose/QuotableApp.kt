package coded.alchemy.quotable.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coded.alchemy.quotable.compose.quoteList.QuoteListScreen
import coded.alchemy.quotable.viewModel.QuoteListViewModel

@Composable
fun QuotableApp() {
    val navController = rememberNavController()
    QuotableNavHost(navController = navController)
}

@Composable
fun QuotableNavHost(
    navController: NavHostController
) {
    val quoteListScreen = "quoteListScreen"

    NavHost(navController = navController, startDestination = quoteListScreen) {
        composable(quoteListScreen) {
            QuoteListScreen()
        }
    }
}
