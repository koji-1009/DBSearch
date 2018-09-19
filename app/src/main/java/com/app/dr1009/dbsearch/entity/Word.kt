package com.app.dr1009.dbsearch.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Word(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        val word: String)