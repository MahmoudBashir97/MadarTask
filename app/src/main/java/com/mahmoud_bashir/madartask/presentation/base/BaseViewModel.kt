package com.mahmoud_bashir.madartask.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(app : Application) : AndroidViewModel(app){

}