package com.example.atsushi.tinyroom.di

import com.example.atsushi.tinyroom.ui.main.MainActivity
import com.example.atsushi.tinyroom.ui.common.UICommonModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [UICommonModule::class, MainBuilderModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}
