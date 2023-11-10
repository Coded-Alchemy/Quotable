package coded.alchemy.quotable.ui.navigation

import androidx.navigation.NavHostController

internal class NavigationDestination(
    navController: NavHostController
) {
    val toQuoteDetail: (String) -> Unit = { quoteId: String ->
        navController.navigate("${Screen.QuoteDetail.route}/$quoteId")
    }
    val toAuthorList: (String) -> Unit = { authorId: String ->
        navController.navigate("${Screen.AuthorList.route}/$authorId")
    }
    val toAuthorQuotes: (String) -> Unit = { authorId: String ->
        navController.navigate("${Screen.AuthorQuoteList.route}/$authorId")
    }
    val toTagList: (String) -> Unit = { tagId: String ->
        navController.navigate("${Screen.TagList.route}/$tagId")
    }
    val up: () -> Unit = {
        navController.navigateUp()
    }
}
