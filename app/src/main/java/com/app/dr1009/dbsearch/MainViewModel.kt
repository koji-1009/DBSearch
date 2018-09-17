package com.app.dr1009.dbsearch

import android.arch.lifecycle.ViewModel
import com.app.dr1009.dbsearch.db.WordDao
import javax.inject.Inject

class MainViewModel @Inject constructor(
        val dao: WordDao
) : ViewModel() {

}