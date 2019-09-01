package com.dr1009.app.dbsearch.di

import android.content.Context
import androidx.room.Room
import com.dr1009.app.dbsearch.App
import com.dr1009.app.dbsearch.db.WordDao
import com.dr1009.app.dbsearch.db.WordDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object AppModule {

    @JvmStatic
    @Provides
    fun provideContext(app: App): Context = app.applicationContext

    @JvmStatic
    @Singleton
    @Provides
    fun provideDB(context: Context): WordDatabase = Room
        .databaseBuilder(context, WordDatabase::class.java, "DBSearch.db").build()

    @JvmStatic
    @Singleton
    @Provides
    fun provideWordDao(db: WordDatabase): WordDao = db.wordDao()
}