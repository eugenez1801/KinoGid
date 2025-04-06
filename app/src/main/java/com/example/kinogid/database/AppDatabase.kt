package com.example.kinogid.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kinogid.User
import com.example.kinogid.UserPreferences
import com.example.kinogid.WatchedMovies

@Database(entities = [ User::class, WatchedMovies::class, UserPreferences::class ], version=1)
@TypeConverters(UserTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}