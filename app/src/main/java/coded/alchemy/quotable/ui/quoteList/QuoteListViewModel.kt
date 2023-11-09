package coded.alchemy.quotable.ui.quoteList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.network.QuotableApi
import coded.alchemy.quotable.network.paging.RemoteMediator
import coded.alchemy.quotable.ui.app.QuotableViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * QuoteListViewModel.kt
 *
 * @author Taji Abdullah
 * */
class QuoteListViewModel : QuotableViewModel() {
    @OptIn(ExperimentalPagingApi::class)
    fun getPagingQuoteFlow(
        database: QuotableDatabase,
        pageSize: Int = 50
    ): Flow<PagingData<QuoteEntity>> {
        return Pager(
            config = PagingConfig(pageSize),
            remoteMediator = createRemoteMediator(database)
        ) {
            database.quoteDao().pagingSource()
        }.flow.cachedIn(viewModelScope)
    }

    private fun createRemoteMediator(database: QuotableDatabase): RemoteMediator {
        return RemoteMediator(
            query = "null",
            database = database,
            quotableApi = QuotableApi.create()
        )
    }
}
