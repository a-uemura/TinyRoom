package com.example.atsushi.tinyroom.di

import com.example.atsushi.tinyroom.TinyRoomApplication
import dagger.*
import dagger.android.*
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityModule::class, ViewModelModule::class, AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<TinyRoomApplication> {

    override fun inject(instance: TinyRoomApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: TinyRoomApplication): Builder

        fun build(): AppComponent
    }
}
