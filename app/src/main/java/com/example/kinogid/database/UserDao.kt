package com.example.kinogid.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kinogid.User
import java.util.UUID

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id = (:id)")
    fun getUser(id: UUID): User//тут еще ? стоит добавить, но пока без него

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user WHERE login = :login AND password = :password")
    suspend fun getUserByLoginAndPassword(login: String, password: String): User?
}