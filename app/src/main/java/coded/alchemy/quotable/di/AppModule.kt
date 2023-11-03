package coded.alchemy.quotable.di

import androidx.room.Room
import coded.alchemy.qoutable.database.QuotableDatabase
import coded.alchemy.qoutable.database.dao.QuoteDao
import coded.alchemy.quotable.data.QuoteRepository
import coded.alchemy.quotable.viewModel.QuoteDetailViewModel
import coded.alchemy.quotable.viewModel.QuoteListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::QuoteListViewModel)
    viewModel { QuoteDetailViewModel(get()) }

    single {
        Room.databaseBuilder(
            androidApplication(),
            QuotableDatabase::class.java,
            QuotableDatabase::class.java.simpleName
        ).build()
    }

    single { QuoteRepository(get()) }
    single {
        val database = get<QuotableDatabase>()
        database.quoteDao()
    }
//    factory { UserPresenter(get()) }
}