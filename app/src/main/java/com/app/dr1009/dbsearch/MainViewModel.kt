package com.app.dr1009.dbsearch

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.app.dr1009.dbsearch.db.WordDao
import com.app.dr1009.dbsearch.entity.Word
import javax.inject.Inject
import kotlin.concurrent.thread

class MainViewModel @Inject constructor(
        private val dao: WordDao
) : ViewModel() {

    val text = MutableLiveData<String>().apply { postValue("") }

    fun words(): LiveData<List<Word>> = Transformations.switchMap(text) {
        if (it.isNullOrBlank()) {
            dao.allLoad()
        } else {
            dao.loadSelect("%$it%")
        }
    }

    fun addWord(word: String) {
        thread { dao.insert(Word(word = word)) }
    }
}

