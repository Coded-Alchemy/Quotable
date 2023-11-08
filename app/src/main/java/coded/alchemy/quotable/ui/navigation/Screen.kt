package coded.alchemy.quotable.ui.navigation

import androidx.annotation.StringRes
import coded.alchemy.quotable.R

internal sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object QuoteList : Screen(Route.QUOTE_LIST, R.string.quoteList)
    data object QuoteDetail : Screen(Route.QUOTE_DETAIL, R.string.quoteDetail)
    data object QuoteAuthor : Screen(Route.QUOTE_AUTHOR, R.string.quoteAuthors)
}
