package com.app.dr1009.dbsearch

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributesMainActivityFragment(): MainActivityFragment

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributesAppWordDialog(): AddWordDialog
}