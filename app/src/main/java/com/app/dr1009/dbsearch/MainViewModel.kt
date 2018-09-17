package com.app.dr1009.dbsearch

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.app.dr1009.dbsearch.db.WordDao
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val dao: WordDao
) : ViewModel() {

    val text = MutableLiveData<String>()

    fun words() = Transformations.switchMap(text) {
        if (it.isNullOrEmpty()) {
            dao.allLoad()
        } else {
            dao.loadSelect("%$it%")
        }
    }!!
}

