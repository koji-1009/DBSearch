package com.app.dr1009.dbsearch.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.dr1009.dbsearch.entity.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordDatabase() : RoomDatabase() {
    abstract fun wordDao(): WordDao
}