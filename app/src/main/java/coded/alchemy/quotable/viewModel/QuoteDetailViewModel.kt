package coded.alchemy.quotable.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coded.alchemy.quotable.data.QuoteRepository
import kotlinx.coroutines.launch

/**
 * QuoteDetailViewModel.kt
 *
 * @author Taji Abdullah
 * */
class QuoteDetailViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun displayQuote(quoteId: String): String {
        var text = ""
         viewModelScope.launch {
            text = quoteRepository.getQuote(quoteId).content
        }
        return text
    }
}