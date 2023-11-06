package coded.alchemy.quotable.network.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.data.QuoteEntity
import coded.alchemy.quotable.network.QuotableApi


@OptIn(ExperimentalPagingApi::class)
fun getQuotePager(string: String, database: QuotableDatabase): Pager<Int, QuoteEntity> {
    return Pager(
        config = PagingConfig(pageSize = 50),
        remoteMediator = RemoteMediator(query = string, database, QuotableApi.create())
    ) {
            database.quoteDao().pagingSource()
    }
}