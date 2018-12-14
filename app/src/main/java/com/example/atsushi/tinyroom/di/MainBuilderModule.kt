package com.example.atsushi.tinyroom.di

import com.example.atsushi.tinyroom.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}
