package coded.alchemy.qoutable.database.data

import androidx.room.Embedded
import androidx.room.Relation

data class QuoteWithTags(
    @Embedded val quoteEntity: QuoteEntity,
    @Relation(
        parentColumn = "quoteId",
        entityColumn = "tagId",
//        associateBy = Junction(QuoteTagRef::class)
    )
    val tags: List<Tag>,
)
