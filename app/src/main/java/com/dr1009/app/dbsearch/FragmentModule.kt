package com.dr1009.app.dbsearch

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributesAppWordDialog(): AddWordDialog
}