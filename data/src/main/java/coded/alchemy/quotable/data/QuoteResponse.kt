package coded.alchemy.quotable.data
/**
 * QuoteResponse.kt
 * @author Taji Abdullah
 *
 * This data class represents the JSON response when getting a page from the network.
 * @property count
 * @property totalCount
 * @property page
 * @property totalPages
 * @property lastItemIndex
 * @property results is a list of [Quote] objects
 * */
data class QuoteResponse(
    val count: Int,
    val totalCount: Int,
    val page: Int,
    val totalPages: Int,
    val lastItemIndex: Int,
    val results: List<Quote>
)
