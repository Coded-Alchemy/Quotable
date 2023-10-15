package coded.alchemy.quotable.compose

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coded.alchemy.quotable.R
import coded.alchemy.quotable.compose.authorList.AuthorListScreen
import coded.alchemy.quotable.compose.quoteDetail.QuoteDetailScreen
import coded.alchemy.quotable.compose.quoteList.QuoteListScreen

@Composable
fun QuotableApp() {
    val navController = rememberNavController()
    QuotableNavHost(navController = navController)
}

@Composable
fun QuotableNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.QuoteList.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(startDestination) {
            QuoteListScreen(navHostController = navController)
        }
        composable(
            Screen.QuoteDetail.route + "/{quoteId}"
        ) {
            QuoteDetailScreen()
        }
        composable(Screen.QuoteAuthor.route) {
            AuthorListScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotableAppbar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
        title = {
            Text(
                stringResource(id = R.string.app_name),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}

@Composable
fun QuotableBottomNavigation(navController: NavController) {
    val screens = listOf(
        Screen.QuoteList,
        Screen.QuoteAuthor
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                label = {
                    Text(
                        text = stringResource(id = screen.resourceId),
                        fontWeight = FontWeight.SemiBold
                    )
                },
                onClick = {
                    navController.navigate(screen.route) /*{
//                        navController.graph.startDestinationRoute?.let { route ->
//                            popUpTo(route) {
//                                saveState = true
//                            }
//                        }
//                        launchSingleTop = true
//                        restoreState = true
                    }*/
                },
                icon = { /*TODO*/ }
            )
        }

//        IconButton(onClick = { /* do something */ }) {
//            Icon(Icons.Filled.Check, contentDescription = "Localized description")
//        }
//        IconButton(onClick = { /* do something */ }) {
//            Icon(Icons.Filled.Check, contentDescription = "Localized description")
//        }

//                Text(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Bottom app bar",
//                )
    }
}
