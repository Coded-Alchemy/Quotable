package coded.alchemy.qoutable.database.data

/**
 * QuoteEntity.kt
 * @author Taji Abdullah
 *
 * This class represents QuoteEntity data.
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
    val authorSlug: String,
    val length: Int,
    val dateAdded: String,
    val dateModified: String
)