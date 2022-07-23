package com.mahmoud_bashir.madartask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahmoud_bashir.madartask.data.model.UserData

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {
    abstract fun dao():UserDao

    companion object{
        const val DATABASE_NAME="user_db"
    }
}