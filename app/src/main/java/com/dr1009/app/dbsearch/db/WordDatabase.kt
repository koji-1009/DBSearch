package com.dr1009.app.dbsearch.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dr1009.app.dbsearch.entity.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordDatabase() : RoomDatabase() {
    abstract fun wordDao(): WordDao
}