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
import kotlinx.coroutines.flow.Flow

/**
 * QuoteListViewModel.kt
 *
 * @author Taji Abdullah
 * */
class QuoteListViewModel() : ViewModel() {

    fun getQuoteFlow(): Flow<PagingData<Quote>> {
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
}
