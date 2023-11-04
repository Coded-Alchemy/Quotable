package coded.alchemy.qoutable.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * QuoteEntity.kt
 *
 * This class represents QuoteEntity data.
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
data class QuoteEntity(
    @PrimaryKey
    @ColumnInfo(name = "quoteId")
    var quoteId: String = "",
    @ColumnInfo(name = "authorId") var authorId: Long = Long.MIN_VALUE,
    @ColumnInfo(name = "content") var content: String = "",
    @ColumnInfo(name = "author_slug") var author_slug: String = "",
    @ColumnInfo(name = "length") var length: Long = Long.MIN_VALUE,
    @ColumnInfo(name = "date_added") var date_added: String = "",
    @ColumnInfo(name = "date_modified") var date_modified: String = ""
)
