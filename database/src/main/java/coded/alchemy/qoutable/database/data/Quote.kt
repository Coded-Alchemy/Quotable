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
 * @property authorSlug
 * @property length
 * @property dateAdded
 * @property dateModified
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
