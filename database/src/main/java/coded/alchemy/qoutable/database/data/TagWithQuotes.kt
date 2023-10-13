package coded.alchemy.qoutable.database.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TagWithQuotes(
    @Embedded val tag: Tag,
    @Relation(
        parentColumn = "tagId",
        entityColumn = "quoteID",
        associateBy = Junction(QuoteTagRef::class)
    )
    val quoteEntities: List<QuoteEntity>
)
