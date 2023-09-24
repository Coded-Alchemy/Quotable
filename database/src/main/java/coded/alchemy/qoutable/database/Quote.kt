package coded.alchemy.qoutable.database

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
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "id") val _id: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "tags") val tags: List<String>?,
    @ColumnInfo(name = "author_slug") val author_slug: String?,
    @ColumnInfo(name = "length") val length: Int?,
    @ColumnInfo(name = "date_added") val date_added: String?,
    @ColumnInfo(name = "date_modified") val date_modified: String?
)
