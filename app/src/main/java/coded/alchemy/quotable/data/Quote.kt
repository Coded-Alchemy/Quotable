package coded.alchemy.quotable.data

data class Quote(
    val _id: String,
    val author: String,
    val content: String,
    val tags: List<String>,
    val author_slug: String,
    val length: Int,
    val date_added: String,
    val date_modified: String
)
