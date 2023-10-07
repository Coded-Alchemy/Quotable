package coded.alchemy.quotable.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coded.alchemy.qoutable.database.data.Quote

private const val STARTING_PAGE_INDEX = 1

class QuotablePagingSource(
    private val quotableApi: QuotableApi,
) : PagingSource<Int, Quote>() {
    override fun getRefreshKey(state: PagingState<Int, Quote>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
            // multiple pages, the initial load will still load items centered around
            // anchorPosition. This also prevents needing to immediately launch prepend due to
            // prefetchDistance.
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Quote> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = quotableApi.getQuotes(page)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.totalPages) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}