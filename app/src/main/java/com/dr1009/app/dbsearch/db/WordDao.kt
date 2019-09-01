package com.dr1009.app.dbsearch.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dr1009.app.dbsearch.entity.Word

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("SELECT * FROM Word")
    fun allLoad(): LiveData<List<Word>>

    @Query("SELECT * FROM Word WHERE word LIKE :word")
    fun loadSelect(word: String): LiveData<List<Word>>
}