package coded.alchemy.qoutable.database.data

import androidx.room.Embedded
import androidx.room.Relation

data class AuthorWithQuotes(
    @Embedded val author: Author,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "quoteId"
    )
    val quotes: List<QuoteWithTags>
)
