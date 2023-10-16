package coded.alchemy.qoutable.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Author(
    @PrimaryKey
    @ColumnInfo(name = "authorId")
    val authorId: Long = Long.MIN_VALUE,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "slug") val slug: String = ""
)
