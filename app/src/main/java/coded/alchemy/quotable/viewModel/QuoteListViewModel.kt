package coded.alchemy.quotable.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.quotable.network.QuotableApi
import coded.alchemy.quotable.network.paging.QuotablePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * QuoteListViewModel.kt
 * @author Taji Abdullah
 *
 * @property quoteResponse
 * */
@HiltViewModel
class QuoteListViewModel @Inject constructor() : ViewModel() {
    private val logTag = this.javaClass.simpleName
//    val quoteResponse: MutableLiveData<QuoteResponse> = MutableLiveData()

    val flow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) {
        QuotablePagingSource(QuotableApi.create())
    }.flow
        .cachedIn(viewModelScope)


    fun getFlow() : Flow<PagingData<Quote>> {
        return Pager(
            config = PagingConfig(
                pageSize = QuotablePagingSource.networkPageSize,
                initialLoadSize = QuotablePagingSource.initialLoad,
                prefetchDistance = QuotablePagingSource.prefetchDistance,
                enablePlaceholders = false
            ),
            initialKey = 1,
            pagingSourceFactory = { QuotablePagingSource(QuotableApi.create()) }
        ).flow
            .cachedIn(viewModelScope)
    }

    /**
     * Calls the [QuotableApi] to obta
     * */
//    fun getQuoteResponse() =
//        viewModelScope.launch {
//            val page = 2
//            quoteResponse.value = QuotableApi.create().getQuotes(page)
//            Log.d(logTag, "getQuoteResponse: ${quoteResponse.value}")
//        }

//    fun storeQuote(
//        dao: QuoteDao,
//        quoteEntity: QuoteEntity
//    ) = viewModelScope.launch(Dispatchers.IO) {
//        Log.d(logTag, "storeQuote: $quoteEntity")
//        QuoteRepository.getInstance(dao).insertQuote(quoteEntity)
//    }

//    fun storeAuthor(
//        dao: QuoteDao,
//        author: Author
//    ) = viewModelScope.launch(Dispatchers.IO) {
//        Log.d(logTag, "storeAuthor: $author")
//        QuoteRepository.getInstance(dao).insertAuthor(author)
//    }

//    fun storeTag(
//        dao: QuoteDao,
//        tag: Tag
//    ) = viewModelScope.launch(Dispatchers.IO) {
//        Log.d(logTag, "storeTag: $tag")
//        QuoteRepository.getInstance(dao).insertTag(tag)
//    }
}
