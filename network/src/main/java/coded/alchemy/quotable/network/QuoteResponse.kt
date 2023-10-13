package coded.alchemy.quotable.network

import coded.alchemy.qoutable.database.data.Quote
import coded.alchemy.qoutable.database.data.QuoteEntity

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
 * @property results is a list of [QuoteEntity] objects
 * */
data class QuoteResponse(
    val count: Int = Int.MIN_VALUE,
    val totalCount: Int = Int.MIN_VALUE,
    val page: Int = Int.MIN_VALUE,
    val totalPages: Int = Int.MIN_VALUE,
    val lastItemIndex: Int = Int.MIN_VALUE,
    val results: List<Quote> = mutableListOf()
)
