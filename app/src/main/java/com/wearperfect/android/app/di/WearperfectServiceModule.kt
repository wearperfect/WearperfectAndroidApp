package com.wearperfect.android.app.di

import com.wearperfect.android.app.constant.network.WearperfectAPIConstant
import com.wearperfect.android.app.data.service.AccountService
import com.wearperfect.android.app.data.service.FeedService
import com.wearperfect.android.app.data.service.ProductService
import com.wearperfect.android.app.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WearperfectServiceModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(WearperfectAPIConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideFeedService(retrofitBuilder: Retrofit.Builder): FeedService {
        return retrofitBuilder.build().create(FeedService::class.java)
    }

    @Singleton
    @Provides
    fun provideUserService(retrofitBuilder: Retrofit.Builder): UserService {
        return retrofitBuilder.build().create(UserService::class.java)
    }

    @Singleton
    @Provides
    fun provideAccountService(retrofitBuilder: Retrofit.Builder): AccountService {
        return retrofitBuilder.build().create(AccountService::class.java)
    }

    @Singleton
    @Provides
    fun provideProductService(retrofitBuilder: Builder): ProductService {
        return retrofitBuilder.build().create(ProductService::class.java)
    }
}