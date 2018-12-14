package com.example.atsushi.tinyroom

import android.app.*
import com.example.atsushi.tinyroom.di.AppInjector
import dagger.android.*
import javax.inject.Inject

class TinyRoomApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this@TinyRoomApplication)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}
