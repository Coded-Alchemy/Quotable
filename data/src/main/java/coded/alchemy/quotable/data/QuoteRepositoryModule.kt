package coded.alchemy.quotable.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {
//    @Binds
//    abstract fun quoteRepoImpl(repository: QuoteRepository):QuoteRepository
}