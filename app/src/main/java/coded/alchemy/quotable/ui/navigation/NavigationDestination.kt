package coded.alchemy.quotable.ui.navigation

import androidx.navigation.NavHostController

internal class NavigationDestination(
    navController: NavHostController
) {
    val quoteDetail: (String) -> Unit = { quoteId: String ->
        navController.navigate("${Route.QUOTE_DETAIL}/$quoteId")
    }
    val authorQuotes: (Long) -> Unit = { authorID: Long ->
        navController.navigate("${Route.QUOTE_AUTHOR}/$authorID")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
