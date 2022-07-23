package com.mahmoud_bashir.madartask.data.repository.local

import androidx.lifecycle.LiveData
import com.mahmoud_bashir.madartask.data.model.UserData
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun insert(userData: UserData)

    fun getAllUserData():Flow<List<UserData>>
}