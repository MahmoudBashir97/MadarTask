package com.mahmoud_bashir.madartask.presentation.fragment.saved

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mahmoud_bashir.madartask.data.model.UserData
import com.mahmoud_bashir.madartask.data.repository.local.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedFragmentViewModel @Inject constructor(app:Application,private val repo:UserRepository):AndroidViewModel(app) {

    val userDataList:MutableLiveData<List<UserData>> = MutableLiveData()
    val userErrorState:MutableLiveData<String> = MutableLiveData()

    init {
        getAllUserData()
    }

    private fun getAllUserData(){
        viewModelScope.launch {
            repo.getAllUserData().
                    catch {
                        userErrorState.postValue(it.message)
                        }.flowOn(Dispatchers.Main)
                .collect { userList ->
                    userDataList.postValue(userList)
                }
        }

    }
}