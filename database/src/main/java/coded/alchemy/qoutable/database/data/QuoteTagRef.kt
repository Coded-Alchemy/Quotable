package coded.alchemy.qoutable.database.data

import androidx.room.Entity

@Entity(primaryKeys = ["quoteId", "tagId"])
data class QuoteTagRef(
    val quoteId: Long,
    val tagId: Long
)
