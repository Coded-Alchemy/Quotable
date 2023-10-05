package coded.alchemy.qoutable.database.data

import androidx.room.Entity

/**
 * QuoteTagRef.kt
 *
 * This class represents a many to many relationship between [QuoteEntity] and [Tag].
 *
 * @property quoteId a [Long] value that represents a [QuoteEntity] id number.
 * @property tagId a [Long] value that represents a [Tag] id number.
 * @author Taji Abdullah
 * */
@Entity(primaryKeys = ["quoteId", "tagId"])
data class QuoteTagRef(
    val quoteId: Long,
    val tagId: Long,
)
