package com.app.dr1009.dbsearch.di

import com.app.dr1009.dbsearch.FragmentModule
import com.app.dr1009.dbsearch.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentModule::class])
internal abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    internal abstract fun contributesMainActivity(): MainActivity
}