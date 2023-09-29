package coded.alchemy.quotable

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coded.alchemy.quotable.network.QuotableApi
import coded.alchemy.quotable.network.QuoteResponse
import kotlinx.coroutines.launch

/**
 * MainActivityViewModel.kt
 * @author Taji Abdullah
 *
 * @property quoteResponse
 * */
class MainActivityViewModel: ViewModel() {
    val quoteResponse: MutableLiveData<QuoteResponse> = MutableLiveData()

    /**
     * Calls the [QuotableApi] to obta
     * */
    fun getQuoteResponse() = viewModelScope.launch {
        val page = 2
        quoteResponse.value = QuotableApi.create().getQuotes(page)
    }
}