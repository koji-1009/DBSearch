package com.app.dr1009.dbsearch.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.app.dr1009.dbsearch.entity.Word

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("SELECT * FROM Word")
    fun allLoad(): LiveData<List<Word>>

    @Query("SELECT * FROM Word WHERE word LIKE :word")
    fun loadSelect(word: String): LiveData<List<Word>>
}