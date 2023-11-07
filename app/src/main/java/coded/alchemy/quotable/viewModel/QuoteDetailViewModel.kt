package coded.alchemy.quotable.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.data.QuoteRepository
import kotlinx.coroutines.launch

/**
 * QuoteDetailViewModel.kt
 *
 * @author Taji Abdullah
 * */
class QuoteDetailViewModel(
    /*private val quoteId: String,*/
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private lateinit var quoteEntity: QuoteEntity

    fun getQuote(quoteId: String): QuoteEntity? {
        viewModelScope.launch {
            quoteEntity = quoteRepository.getQuote(quoteId)
        }
        if (::quoteEntity.isInitialized) {
            return quoteEntity
        }
        return null
    }
}
