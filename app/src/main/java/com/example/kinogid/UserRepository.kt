package com.example.kinogid

import android.content.Context
import androidx.room.Room
import com.example.kinogid.database.AppDatabase
import com.example.kinogid.database.UserDao
import java.util.UUID


class UserRepository(private val userDao: UserDao) {
    fun getUser(id: UUID): User{ //LiveData<User?>
        return userDao.getUser(id)
    }

    suspend fun getUserByLogin(login: String): User{
        return userDao.getUserByLogin(login) /*при использовании такого способа нужно
         гарантировать уникальность каждого логина*/
    }

    suspend fun addUser(user: User): Boolean{
        try {
            userDao.addUser(user)
            return true
        } catch (e: Exception){ /*catch (e: SQLiteConstraintException) от дипсика*/
            return false
        }
        /*userDao.addUser(user)*/
    }

    suspend fun authenticate(login: String, password: String): User?{
        return userDao.getUserByLoginAndPassword(login, password)
    }
}