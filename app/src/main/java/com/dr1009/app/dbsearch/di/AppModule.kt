package com.dr1009.app.dbsearch.di

import android.content.Context
import androidx.room.Room
import com.dr1009.app.dbsearch.App
import com.dr1009.app.dbsearch.db.WordDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Provides
    fun provideContext(app: App): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideDB(context: Context): WordDatabase = Room
            .databaseBuilder(context, WordDatabase::class.java, "DBSearch.db").build()

    @Singleton
    @Provides
    fun provideWordDao(db: WordDatabase) = db.wordDao()
}