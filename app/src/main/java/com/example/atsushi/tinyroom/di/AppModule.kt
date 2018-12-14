package com.example.atsushi.tinyroom.di

import android.app.Application
import android.content.*
import android.preference.PreferenceManager
import com.example.atsushi.tinyroom.TinyRoomApplication
import dagger.*
import javax.inject.Singleton

@Module
internal class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreference(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun provideApplication(application: TinyRoomApplication): Application = application

    @Provides
    fun provideContext(application: TinyRoomApplication): Context = application.applicationContext
}
