package coded.alchemy.quotable.ui.navigation

import androidx.annotation.StringRes
import coded.alchemy.quotable.R

/**
 * Sealed class to hold Application screens.
 * */
sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object QuoteList : Screen(Route.QUOTE_LIST, R.string.quoteList)
    data object QuoteDetail : Screen(Route.QUOTE_DETAIL, R.string.quoteList)
    data object AuthorList : Screen(Route.AUTHOR_LIST, R.string.authorList)
    data object TagList : Screen(Route.TAG_LIST, R.string.tagList)
}

fun navbarAccessibleScreens() = listOf(
    Screen.QuoteList,
    Screen.AuthorList,
    Screen.TagList
)
