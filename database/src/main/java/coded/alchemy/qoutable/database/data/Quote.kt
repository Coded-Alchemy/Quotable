package coded.alchemy.qoutable.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Quote.kt
 *
 * This class represents Quote data.
 *
 * @property _id
 * @property author
 * @property content
 * @property tags
 * @property author_slug
 * @property length
 * @property date_added
 * @property date_modified
 * @author Taji Abdullah
 * */
@Entity
data class Quote(
    @PrimaryKey @ColumnInfo(name = "quoteId") val quoteId: Long,
    @ColumnInfo(name = "authorId") val authorId: Long,
    @ColumnInfo(name = "content") val content: String,
//    @ColumnInfo(name = "author_slug") val author_slug: String?,
    @ColumnInfo(name = "length") val length: Int?,
    @ColumnInfo(name = "date_added") val date_added: String?,
    @ColumnInfo(name = "date_modified") val date_modified: String?
)
