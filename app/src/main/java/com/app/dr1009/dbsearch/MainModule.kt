package com.app.dr1009.dbsearch

import android.arch.lifecycle.ViewModel
import com.app.dr1009.dbsearch.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindLaunchViewModel(viewModel: MainViewModel): ViewModel
}