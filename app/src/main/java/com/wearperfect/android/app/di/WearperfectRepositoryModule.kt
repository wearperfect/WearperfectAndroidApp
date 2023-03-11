package com.wearperfect.android.app.di

import com.wearperfect.android.app.data.dao.AccountDAO
import com.wearperfect.android.app.data.repository.*
import com.wearperfect.android.app.data.service.AccountService
import com.wearperfect.android.app.data.service.FeedService
import com.wearperfect.android.app.data.service.ProductService
import com.wearperfect.android.app.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WearperfectRepositoryModule {

    @Singleton
    @Provides
    fun provideAccountRepository(accountDAO: AccountDAO, accountService: AccountService): AccountRepository =
        AccountRepository(accountDAO = accountDAO, accountService = accountService)

    @Singleton
    @Provides
    fun provideUserRepository(userService: UserService, preferencesDataStoreRepository: PreferencesDataStoreRepository): UserRepository =
        UserRepository(userService, preferencesDataStoreRepository)

    @Singleton
    @Provides
    fun provideFeedRepository(feedService: FeedService): FeedRepository =
        FeedRepository(feedService)

    @Singleton
    @Provides
    fun provideProductRepository(productService: ProductService): ProductRepository =
        ProductRepository(productService)
}