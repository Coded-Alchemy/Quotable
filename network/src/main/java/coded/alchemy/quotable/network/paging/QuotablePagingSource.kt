package coded.alchemy.quotable.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.quotable.network.QuotableApi
import retrofit2.HttpException

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
            // IOException for network failures.
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            return LoadResult.Error(exception)
        }
    }

    companion object {
        const val networkPageSize = 20
        const val initialLoad = 20
        const val prefetchDistance = 2
    }
}