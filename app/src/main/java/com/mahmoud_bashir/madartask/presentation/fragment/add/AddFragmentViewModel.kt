package com.mahmoud_bashir.madartask.presentation.fragment.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud_bashir.madartask.data.model.UserData
import com.mahmoud_bashir.madartask.data.repository.local.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFragmentViewModel @Inject constructor(app:Application, private val repo : UserRepository): AndroidViewModel(app) {

    fun insertUserData(userData: UserData) = viewModelScope.launch{
        repo.insert(userData)
    }
}