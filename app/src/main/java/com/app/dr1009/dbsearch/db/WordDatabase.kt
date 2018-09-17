package com.app.dr1009.dbsearch.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.app.dr1009.dbsearch.entity.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordDatabase() : RoomDatabase() {
    abstract fun wordDao(): WordDao
}