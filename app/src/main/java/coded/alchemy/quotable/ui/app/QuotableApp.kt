package coded.alchemy.quotable.ui.app

import android.R.color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coded.alchemy.quotable.R
import coded.alchemy.quotable.ui.navigation.QuotableNavHost
import coded.alchemy.quotable.ui.navigation.navbarAccessibleScreens
import org.koin.androidx.compose.KoinAndroidContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotableApp() {
    // Set current Koin instance to Compose context
    KoinAndroidContext {
        val navController = rememberNavController()

        Scaffold(
            topBar = {
                QuotableAppbar()
            },
            bottomBar = {
                QuotableBottomNavigation(navController)
            }
        ) { innerPadding ->
            QuotableNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
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
fun QuotableBottomNavigation(navController: NavHostController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navbarAccessibleScreens().forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                label = {
                    Text(
                        text = stringResource(id = screen.caption),
                        fontWeight = FontWeight.SemiBold
                    )
                },
                onClick = {
                    navController.navigate(screen.route)
                },
                icon = { /*TODO*/ }
            )
        }
    }
}

@Composable
fun QuotableProgress() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LinearProgressIndicator(
            modifier = Modifier.width(128.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}
