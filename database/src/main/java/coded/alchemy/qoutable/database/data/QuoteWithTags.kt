package coded.alchemy.qoutable.database.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class QuoteWithTags(
    @Embedded val quote: Quote,
    @Relation(
        parentColumn = "quoteId",
        entityColumn = "tagId",
//        associateBy = Junction(QuoteTagRef::class)
    )
    val tags: List<Tag>
)
