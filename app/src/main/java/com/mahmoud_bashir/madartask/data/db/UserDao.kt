package com.mahmoud_bashir.madartask.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahmoud_bashir.madartask.data.model.UserData

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userData: UserData)

    @Query("SELECT * FROM UserData ORDER BY id ASC")
    fun getAllUserData():LiveData<List<UserData>>
}