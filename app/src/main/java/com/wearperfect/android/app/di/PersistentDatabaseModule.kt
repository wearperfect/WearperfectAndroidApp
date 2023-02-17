package com.wearperfect.android.app.di

import android.content.Context
import androidx.room.Room
import com.wearperfect.android.app.data.WearperfectPersistentDatabase
import com.wearperfect.android.app.data.dao.AccountDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistentDatabaseModule {

    @Singleton
    @Provides
    fun provideWearperfectPersistentDatabase(@ApplicationContext context: Context): WearperfectPersistentDatabase =
        Room.databaseBuilder(
            context,
            WearperfectPersistentDatabase::class.java,
            "wearperfect"
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideAccountDAO(wearperfectPersistentDatabase: WearperfectPersistentDatabase): AccountDAO =
        wearperfectPersistentDatabase.getAccountDAO()
}