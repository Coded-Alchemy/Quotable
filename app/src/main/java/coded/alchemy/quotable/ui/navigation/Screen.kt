package coded.alchemy.quotable.ui.navigation

import androidx.annotation.StringRes
import coded.alchemy.quotable.R

/**
 * Sealed class to hold Application screens.
 * */
sealed class Screen(val route: String, @StringRes val caption: Int) {
    data object QuoteList : Screen(route = Route.QUOTE_LIST, caption = R.string.quoteList)
    data object QuoteDetail : Screen(route = Route.QUOTE_DETAIL, caption = 0)
    data object AuthorList : Screen(route = Route.AUTHOR_LIST, caption = R.string.authorList)
    data object AuthorQuoteList : Screen(route = Route.AUTHOR_QUOTES, caption = 0)
    data object TagList : Screen(route = Route.TAG_LIST, caption = R.string.tagList)
}

/**
 * List of screens that populate the bottomNav bar.
 * */
fun navbarAccessibleScreens() = listOf(
    Screen.QuoteList,
    Screen.AuthorList,
    Screen.TagList
)
