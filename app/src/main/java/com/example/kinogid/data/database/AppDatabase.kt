package com.example.kinogid.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kinogid.data.models.ListMovies
import com.example.kinogid.data.models.User
import com.example.kinogid.data.models.UserPreferences
import com.example.kinogid.data.models.WatchedMovie

@Database(entities = [ User::class, WatchedMovie::class, ListMovies::class, UserPreferences::class ], version=1)
@TypeConverters(UserTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this){
                instance ?: buildDataBase(context).also { instance = it }
            }
        }

        private fun buildDataBase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()
        }
    }
}