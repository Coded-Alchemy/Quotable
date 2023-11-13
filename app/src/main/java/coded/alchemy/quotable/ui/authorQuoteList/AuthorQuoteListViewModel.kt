package coded.alchemy.quotable.ui.authorQuoteList

import coded.alchemy.quotable.data.AuthorRepository
import coded.alchemy.quotable.ui.app.QuotableViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthorQuoteListViewModel(private val authorRepository: AuthorRepository) : QuotableViewModel() {

    fun getAuthorWithQuotes(authorName: String): Flow<AuthorWithQuotesState> = flow {
        try {
            emit(AuthorWithQuotesState.Loading)
            val authorWithQuotes = authorRepository.getAuthorWithQuotes(authorName)
            emit(AuthorWithQuotesState.Success(authorWithQuotes))
        } catch (e: Exception) {
            emit(AuthorWithQuotesState.Error(e.message ?: "An error occurred"))
        }
    }.flowOn(Dispatchers.IO)
}
