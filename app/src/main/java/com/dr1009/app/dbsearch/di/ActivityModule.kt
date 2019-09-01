package com.dr1009.app.dbsearch.di

import com.dr1009.app.dbsearch.FragmentModule
import com.dr1009.app.dbsearch.MainActivity
import com.dr1009.app.dbsearch.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentModule::class])
internal abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributesMainActivity(): MainActivity
}