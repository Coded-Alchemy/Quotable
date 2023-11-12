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
import coded.alchemy.quotable.ui.authorQuoteList.AuthorQuoteListScreen
import coded.alchemy.quotable.ui.navigation.Route.AUTHOR_ID
import coded.alchemy.quotable.ui.navigation.Route.QUOTE_ID
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
        // Quote list screen
        composable(
            route = startDestination,
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
        // Quote detail screen
        composable(
            route = "${Screen.QuoteDetail.route}/{$QUOTE_ID}",
            arguments = listOf(
                navArgument(QUOTE_ID) {
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
            arguments.getString(QUOTE_ID)?.let { quoteId ->
                QuoteDetailScreen(
                    quoteId = quoteId,
                    navigateUp = navigate.up
                )
            }
        }
        // Author screen
        composable(
            route = Screen.AuthorList.route,
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
            AuthorListScreen(onAuthorClick = navigate.toAuthorList)
        }
        // Author quote list screen
        composable(
            route = "${Screen.AuthorList.route}/{$AUTHOR_ID}",
            arguments = listOf(
                navArgument(AUTHOR_ID) {
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
            arguments.getString(AUTHOR_ID)?.let { authorId ->
                AuthorQuoteListScreen(
                    authorId = authorId,
                    navigateUp = navigate.up,
                    onQuoteClick = navigate.toQuoteDetail
                )
            }
        }
        // Tag list screen
        composable(
            route = Screen.TagList.route,
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
            TagListScreen(onTagClick = navigate.toTagList)
        }
    }
}
