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
 *
 * @author Taji Abdullah
 * */
@HiltViewModel
class QuoteListViewModel @Inject constructor() : ViewModel() {

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
