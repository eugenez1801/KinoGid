package com.example.kinogid.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kinogid.User
import com.example.kinogid.UserPreferences
import com.example.kinogid.WatchedMovie
import java.util.UUID

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id = (:id)")
    fun getUser(id: UUID): User

    @Query("SELECT * FROM user WHERE login = (:login)")
    suspend fun getUserByLogin(login: String): User?

    @Query("SELECT * FROM user WHERE name = (:name)")
    suspend fun getUserByName(name: String): User?

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user WHERE login = :login AND password = :password")
    suspend fun getUserByLoginAndPassword(login: String, password: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)//замена, если UUID одинаковый
    suspend fun savePreferences(preferences: UserPreferences)

    @Query("SELECT * FROM UserPreferences WHERE userId = (:userId)")
    suspend fun getPreferences(userId: UUID): UserPreferences?

    @Insert
    suspend fun makeMovieIsWatched(watchedMovie: WatchedMovie)

    @Query("SELECT * FROM WatchedMovie WHERE userId = :userId AND movieId = :movieId")
    suspend fun getWatchedMovie(userId: UUID, movieId: Int): WatchedMovie?

    @Query("DELETE FROM WatchedMovie WHERE userId = :userId AND movieId = :movieId")
    suspend fun deleteWatchedMovie(userId: UUID, movieId: Int)

    @Query("SELECT movieId FROM WatchedMovie WhERE userId = :userId")
    suspend fun getListWatchedMovies(userId: UUID): List<Int>?
}