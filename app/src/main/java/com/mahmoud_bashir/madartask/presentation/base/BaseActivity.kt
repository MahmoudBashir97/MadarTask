package com.mahmoud_bashir.madartask.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initEvent()
        initViewModel()
        initLoading()
        initObservers()
        initErrorObservers()
    }

    abstract fun initEvent()

    abstract fun initViewModel()

    abstract fun initObservers()

    abstract fun initErrorObservers()

    abstract fun initLoading()
}