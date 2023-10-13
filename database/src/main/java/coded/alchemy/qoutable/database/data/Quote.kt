package coded.alchemy.qoutable.database.data

/**
 * Quote.kt
 * @author Taji Abdullah
 *
 * This class represents a Quote object.
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
    val _id: String = "",
    val author: String = "",
    val content: String = "",
    val tags: List<String> = mutableListOf(),
    val authorSlug: String = "",
    val length: Int = Int.MIN_VALUE,
    val dateAdded: String = "",
    val dateModified: String = ""
)
