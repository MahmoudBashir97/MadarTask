package com.mahmoud_bashir.madartask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,
    @ColumnInfo(name = "name")
    val name:String?,
    @ColumnInfo(name = "age")
    val age:Int?,
    @ColumnInfo(name = "job_title")
    val jobTitle:String?,
    @ColumnInfo(name = "gender")
    val gender:String?
)
