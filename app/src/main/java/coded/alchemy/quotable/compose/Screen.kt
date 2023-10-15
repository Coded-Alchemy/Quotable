package coded.alchemy.quotable.compose

import androidx.annotation.StringRes
import coded.alchemy.quotable.R
import coded.alchemy.quotable.util.Constant.Companion.QUOTE_AUTHOR
import coded.alchemy.quotable.util.Constant.Companion.QUOTE_DETAIL
import coded.alchemy.quotable.util.Constant.Companion.QUOTE_LIST

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object QuoteList : Screen(QUOTE_LIST, R.string.quoteList)
    data object QuoteDetail : Screen(QUOTE_DETAIL, R.string.quoteDetail)
    data object QuoteAuthor : Screen(QUOTE_AUTHOR, R.string.quoteAuthors)
}
