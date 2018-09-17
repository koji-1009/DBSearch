package com.app.dr1009.dbsearch

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributesMainActivityFragment(): MainActivityFragment
}