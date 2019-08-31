package com.app.dr1009.dbsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.dr1009.dbsearch.db.WordDao
import com.app.dr1009.dbsearch.entity.Word
import javax.inject.Inject
import kotlin.concurrent.thread

class MainViewModel @Inject constructor(
        private val dao: WordDao
) : ViewModel() {

    val text = MutableLiveData<String>().apply { postValue("") }

    fun words(): LiveData<List<Word>> {
        return Transformations.switchMap(text) {
            if (it.isNullOrBlank()) {
                dao.allLoad()
            } else {
                dao.loadSelect("%$it%")
            }
        }
    }

    fun addWord(word: String) {
        thread { dao.insert(Word(word = word)) }
    }
}

