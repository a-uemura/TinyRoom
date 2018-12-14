package com.example.atsushi.tinyroom.ui.main

import android.os.Bundle
import com.example.atsushi.tinyroom.R
import dagger.android.support.*

class MainActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,
                            MainFragment.newInstance()).commitNow()
        }
    }
}
