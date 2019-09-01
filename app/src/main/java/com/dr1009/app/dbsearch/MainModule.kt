package com.dr1009.app.dbsearch

import androidx.lifecycle.ViewModel
import com.dr1009.app.dbsearch.di.ViewModelKey
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