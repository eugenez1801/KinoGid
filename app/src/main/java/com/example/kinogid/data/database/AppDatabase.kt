package com.example.kinogid.data.database

import androidx.room.Database
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
}