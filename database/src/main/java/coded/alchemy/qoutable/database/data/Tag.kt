package coded.alchemy.qoutable.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag(
    @PrimaryKey
    @ColumnInfo(name = "content")
    val content: String = "",
    @ColumnInfo(name = "quoteId") val quoteId: String = ""
)
