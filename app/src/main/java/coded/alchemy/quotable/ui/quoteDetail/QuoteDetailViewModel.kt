package coded.alchemy.quotable.ui.quoteDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.data.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
    private val _quote = MutableStateFlow<QuoteEntity?>(null)
    val quote: StateFlow<QuoteEntity?> = _quote

    fun getQuote(quoteId: String) {
        viewModelScope.launch {
            val quoteFlow = quoteRepository.getQuoteFlow(quoteId)
            quoteFlow.collect { quote ->
                _quote.value = quote
            }
        }
    }
}
