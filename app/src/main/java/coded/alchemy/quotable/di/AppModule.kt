package coded.alchemy.quotable.di

import coded.alchemy.quotable.viewModel.QuoteListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::QuoteListViewModel)
//    single<UserRepository> { UserRepositoryImpl() }
//    single { UserService(get()) }
//    factory { UserPresenter(get()) }
}