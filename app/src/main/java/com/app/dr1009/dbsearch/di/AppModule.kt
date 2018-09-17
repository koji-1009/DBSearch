package com.app.dr1009.dbsearch.di

import android.arch.persistence.room.Room
import android.content.Context
import com.app.dr1009.dbsearch.db.WordDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): WordDatabase = Room
            .databaseBuilder(context, WordDatabase::class.java, "DBSearch.db").build()

    @Singleton
    @Provides
    fun provideWordDao(db: WordDatabase) = db.wordDao()
}