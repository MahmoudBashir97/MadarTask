package com.mahmoud_bashir.madartask.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahmoud_bashir.madartask.R
import com.mahmoud_bashir.madartask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }
}