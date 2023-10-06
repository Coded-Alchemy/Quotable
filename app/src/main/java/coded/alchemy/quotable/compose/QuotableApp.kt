package coded.alchemy.quotable.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.compose.quoteList.QuoteListScreen
import coded.alchemy.quotable.viewModel.MainActivityViewModel

@Composable
fun QuotableApp(viewModel: MainActivityViewModel) {
    val navController = rememberNavController()
    QuotableNavHost(navController = navController, viewModel)
}

@Composable
fun QuotableNavHost(
    navController: NavHostController,
    viewModel: MainActivityViewModel
) {
    val quoteListScreen = "quoteListScreen"

    NavHost(navController = navController, startDestination = quoteListScreen) {
        composable(quoteListScreen) {
            QuoteListScreen(viewModel)
        }
    }
}
