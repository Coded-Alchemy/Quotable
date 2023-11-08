package coded.alchemy.quotable.di

import androidx.room.Room
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.quotable.data.AuthorRepository
import coded.alchemy.quotable.data.QuoteRepository
import coded.alchemy.quotable.data.TagRepository
import coded.alchemy.quotable.ui.authorList.AuthorListViewModel
import coded.alchemy.quotable.ui.quoteDetail.QuoteDetailViewModel
import coded.alchemy.quotable.ui.quoteList.QuoteListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import coded.alchemy.quotable.ui.tagList.TagListViewModel

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            QuotableDatabase::class.java,
            QuotableDatabase::class.java.simpleName
        ).build()
    }

    viewModelOf(::QuoteListViewModel)
    single { QuoteRepository(get()) }
    single {
        val database = get<QuotableDatabase>()
        database.quoteDao()
    }

    viewModelOf(::QuoteDetailViewModel)

    viewModelOf(::AuthorListViewModel)
    single { AuthorRepository(get()) }
    single {
        val database = get<QuotableDatabase>()
        database.authorDao()
    }

    viewModelOf(::TagListViewModel)
    single { TagRepository(get()) }
    single {
        val database = get<QuotableDatabase>()
        database.tagDao()
    }
}
