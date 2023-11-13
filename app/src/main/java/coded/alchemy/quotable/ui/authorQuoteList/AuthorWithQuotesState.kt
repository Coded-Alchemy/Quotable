package coded.alchemy.quotable.ui.authorQuoteList

import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity

sealed class AuthorWithQuotesState {
    data object Loading : AuthorWithQuotesState()
    data class Success(val data: Map<Author, List<QuoteEntity>>) : AuthorWithQuotesState()
    data class Error(val message: String) : AuthorWithQuotesState()
}
