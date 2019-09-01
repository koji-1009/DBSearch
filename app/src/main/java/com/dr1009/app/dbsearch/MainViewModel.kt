package com.dr1009.app.dbsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dr1009.app.dbsearch.db.WordDao
import com.dr1009.app.dbsearch.entity.Word
import javax.inject.Inject
import kotlin.concurrent.thread

class MainViewModel @Inject constructor(
    private val dao: WordDao
) : ViewModel() {

    val text = MutableLiveData<String>()

    fun words(): LiveData<List<Word>> = Transformations.switchMap(text) {
        if (it.isNullOrBlank()) {
            dao.allLoad()
        } else {
            dao.loadSelect("%$it%")
        }
    }

    fun addWord(word: String) {
        if (word.isNotEmpty()) return

        thread { dao.insert(Word(word = word)) }
    }
}

