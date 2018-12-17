package com.example.atsushi.tinyroom.ext

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment

inline fun <reified T : ViewModel> FragmentActivity.getActivityViewModel(
        viewModelFactory: ViewModelProvider.Factory? = null
): T {
    return viewModelFactory?.let {
        ViewModelProviders.of(this, it).get(T::class.java)
    } ?: ViewModelProviders.of(this).get(T::class.java)
}

fun <T : ViewDataBinding> Activity.setContentWithBind(
        @LayoutRes layoutId: Int
): T {
    return DataBindingUtil.setContentView(this, layoutId)
}

fun FragmentActivity.getCurrentFragment(
        @IdRes id: Int
): Fragment? {
    val navHostFragment = supportFragmentManager.findFragmentById(id) as? NavHostFragment
            ?: return null
    return navHostFragment.childFragmentManager.findFragmentById(id)
}

inline fun <reified T : Fragment> FragmentActivity.getCurrentSpecificFragment(
        @IdRes id: Int
): T? {
    val navHostFragment = supportFragmentManager.findFragmentById(id) as? NavHostFragment
            ?: return null
    val currentFragment = navHostFragment.childFragmentManager.findFragmentById(id) ?: return null
    if (currentFragment is T) {
        return currentFragment
    }
    return null
}
