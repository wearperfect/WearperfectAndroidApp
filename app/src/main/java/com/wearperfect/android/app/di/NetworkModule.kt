package com.wearperfect.android.app.di

import android.util.Log
import com.wearperfect.android.app.data.repository.PreferencesDataStoreRepository
import com.wearperfect.android.app.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthInterceptor(preferencesDataStoreRepository: PreferencesDataStoreRepository) =
        AuthInterceptor(preferencesDataStoreRepository)

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(authInterceptor)
            addInterceptor(loggingInterceptor)
            Log.i("NetworkModule", "provideOkHttpClient: ${authInterceptor.toString()}")
        }.build()
        return okHttpClient
    }
}