package coded.alchemy.quotable.viewModel

import android.util.Log
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
 *
 * @author Taji Abdullah
 * */
@HiltViewModel
class QuoteListViewModel @Inject constructor() : ViewModel() {
    private val logTag = this.javaClass.simpleName

    fun getQuoteFlow(): Flow<PagingData<Quote>> {
        Log.d(logTag, "getFlow:")
        val pagingQuoteData = Pager(
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
        Log.d(logTag, "getFlow: $pagingQuoteData")
        return pagingQuoteData
    }
}
