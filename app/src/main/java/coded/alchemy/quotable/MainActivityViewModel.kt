package coded.alchemy.quotable

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.qoutable.database.data.Author
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.qoutable.database.data.Tag
import coded.alchemy.quotable.data.QuoteRepository
import coded.alchemy.quotable.network.QuotableApi
import coded.alchemy.quotable.network.QuoteResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * MainActivityViewModel.kt
 * @author Taji Abdullah
 *
 * @property quoteResponse
 * */
@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {
    private val logTag = this.javaClass.simpleName
    val quoteResponse: MutableLiveData<QuoteResponse> = MutableLiveData()

    /**
     * Calls the [QuotableApi] to obta
     * */
    fun getQuoteResponse() =
        viewModelScope.launch {
            val page = 2
            quoteResponse.value = QuotableApi.create().getQuotes(page)
            Log.d(logTag, "getQuoteResponse: ${quoteResponse.value}")
        }

    fun storeQuote(
        dao: QuoteDao,
        quoteEntity: QuoteEntity
    ) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(logTag, "storeQuote: $quoteEntity")
        QuoteRepository.getInstance(dao).insertQuote(quoteEntity)
    }

    fun storeAuthor(
        dao: QuoteDao,
        author: Author
    ) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(logTag, "storeAuthor: $author")
        QuoteRepository.getInstance(dao).insertAuthor(author)
    }

    fun storeTag(
        dao: QuoteDao,
        tag: Tag
    ) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(logTag, "storeTag: $tag")
        QuoteRepository.getInstance(dao).insertTag(tag)
    }
}
