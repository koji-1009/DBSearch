package com.app.dr1009.dbsearch.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        val word: String)