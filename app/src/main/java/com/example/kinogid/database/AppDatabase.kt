package com.example.kinogid.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kinogid.User

@Database(entities = [ User::class ], version=1)
@TypeConverters(UserTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}