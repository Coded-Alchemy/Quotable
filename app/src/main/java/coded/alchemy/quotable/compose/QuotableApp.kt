package coded.alchemy.quotable.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coded.alchemy.quotable.compose.quoteList.QuoteListScreen
import coded.alchemy.quotable.viewModel.QuoteListViewModel

@Composable
fun QuotableApp(viewModel: QuoteListViewModel) {
    val navController = rememberNavController()
    QuotableNavHost(navController = navController, viewModel)
}

@Composable
fun QuotableNavHost(
    navController: NavHostController,
    viewModel: QuoteListViewModel
) {
    val quoteListScreen = "quoteListScreen"

    NavHost(navController = navController, startDestination = quoteListScreen) {
        composable(quoteListScreen) {
            QuoteListScreen(viewModel)
        }
    }
}
