package coded.alchemy.quotable.compose

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coded.alchemy.quotable.R
import coded.alchemy.quotable.compose.AppDestinations.CAT_DETAIL_ID_KEY
import coded.alchemy.quotable.compose.authorList.AuthorListScreen
import coded.alchemy.quotable.compose.quoteDetail.QuoteDetailScreen
import coded.alchemy.quotable.compose.quoteList.QuoteListScreen

/**
 *
 */
object AppDestinations {
    const val QUOTE_LIST = "quoteList"
    const val QUOTE_DETAIL = "quoteDetail"
    const val QUOTE_AUTHOR = "quoteAuthor"
    const val CAT_DETAIL_ID_KEY = "quoteId"
}

@Composable
fun QuotableNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.QuoteList.route
) {
    val actions = remember(navController) { AppActions(navController) }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(startDestination) {
            QuoteListScreen(selectedQuote = actions.selectedQuote)
        }
        composable(
            Screen.QuoteDetail.route /*+ CAT_DETAIL_ID_KEY*/
//            arguments = listOf(
//                navArgument(CAT_DETAIL_ID_KEY) {
//                    type = NavType.StringType
//                }
//            )
        ) { backStack ->
            val arguments = requireNotNull(backStack.arguments)
            arguments.getString(CAT_DETAIL_ID_KEY)
                ?.let { quoteId ->
                    QuoteDetailScreen(
                        quoteId = quoteId,
                        navigateUp = actions.navigateUp
                    )
                }
        }
        composable(Screen.QuoteAuthor.route) {
            AuthorListScreen()
        }
    }
}

class AppActions(
    navController: NavHostController
) {
    val selectedQuote: (String) -> Unit = { quoteId: String ->
        navController.navigate("${AppDestinations.QUOTE_DETAIL}") // /$quoteId
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object QuoteList : Screen(AppDestinations.QUOTE_LIST, R.string.quoteList)
    data object QuoteDetail : Screen(AppDestinations.QUOTE_DETAIL, R.string.quoteDetail)
    data object QuoteAuthor : Screen(AppDestinations.QUOTE_AUTHOR, R.string.quoteAuthors)
}
