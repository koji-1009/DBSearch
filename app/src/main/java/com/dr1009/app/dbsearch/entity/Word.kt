package com.dr1009.app.dbsearch.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val word: String
)