package coded.alchemy.quotable.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coded.alchemy.quotable.ui.authorList.AuthorListScreen
import coded.alchemy.quotable.ui.navigation.Route.Quote_ID
import coded.alchemy.quotable.ui.quoteDetail.QuoteDetailScreen
import coded.alchemy.quotable.ui.quoteList.QuoteListScreen
import coded.alchemy.quotable.ui.tagList.TagListScreen

/**
 *
 */
@Composable
fun QuotableNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.QuoteList.route
) {
    val navigate = remember(navController) { NavigationDestination(navController) }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            startDestination,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            QuoteListScreen(onQuoteClick = navigate.toQuoteDetail)
        }
        composable(
            "${Screen.QuoteDetail.route}/{$Quote_ID}",
            arguments = listOf(
                navArgument(Quote_ID) {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                    animationSpec = tween(700)
                )
            }
        ) { backStack ->
            val arguments = requireNotNull(backStack.arguments)
            arguments.getString(Quote_ID)?.let {
                QuoteDetailScreen(
                    quoteId = it,
                    navigateUp = navigate.up
                )
            }
        }
        composable(Screen.AuthorList.route) {
            AuthorListScreen(onAuthorClick = navigate.toAuthorList)
        }
        composable(Screen.TagList.route) {
            TagListScreen(onTagClick = navigate.toTagList)
        }
    }
}
