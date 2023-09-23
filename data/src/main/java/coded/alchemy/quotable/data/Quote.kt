package coded.alchemy.quotable.data

/**
 * Quote.kt
 * @author Taji Abdullah
 *
 * This class represents Quote data.
 * @property _id
 * @property author
 * @property content
 * @property tags
 * @property author_slug
 * @property length
 * @property date_added
 * @property date_modified
 * */
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
