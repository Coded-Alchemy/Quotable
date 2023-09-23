package coded.alchemy.quotable

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coded.alchemy.quotable.data.QuoteResponse
import coded.alchemy.quotable.network.QuotableApi
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    val quoteResponse: MutableLiveData<QuoteResponse> = MutableLiveData()

    fun getQuoteResponse() = viewModelScope.launch {
        quoteResponse.value = QuotableApi.create().getQuotes()
    }
}