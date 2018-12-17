package com.example.atsushi.tinyroom.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.atsushi.tinyroom.R
import com.example.atsushi.tinyroom.ext.getActivityViewModel
import com.example.atsushi.tinyroom.ext.getCurrentFragment
import com.example.atsushi.tinyroom.ui.common.OnBackPressHandler
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        viewModel = getActivityViewModel(viewModelProviderFactory)
    }

    override fun onBackPressed() {
        val currentFragment = getCurrentFragment(R.id.container)
        if (currentFragment is OnBackPressHandler) {
            if (currentFragment.onBackPressed()) return
        }
        super.onBackPressed()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = androidInjector

    companion object {
        fun start(context: Context) {
            Intent(context, MainActivity::class.java).let { context.startActivity(it) }
        }
    }
}
