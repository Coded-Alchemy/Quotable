package coded.alchemy.quotable.data

data class QuoteResponse(
    val count: Int,
    val totalCount: Int,
    val page: Int,
    val totalPages: Int,
    val lastItemIndex: Int,
    val results: List<Quote>
)
