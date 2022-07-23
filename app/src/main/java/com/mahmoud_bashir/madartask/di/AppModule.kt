package com.mahmoud_bashir.madartask.di

import android.content.Context
import androidx.room.Room
import com.mahmoud_bashir.madartask.data.db.UserDao
import com.mahmoud_bashir.madartask.data.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun providerUserDatabase(@ApplicationContext context: Context):UserDatabase{
        return Room.databaseBuilder(context,
            UserDatabase::class.java,
            UserDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDatabase:UserDatabase):UserDao{
        return userDatabase.dao()
    }
}