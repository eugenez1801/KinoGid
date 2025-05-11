package com.example.kinogid.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kinogid.data.models.ListMovies
import com.example.kinogid.data.models.User
import com.example.kinogid.data.models.UserPreferences
import com.example.kinogid.data.models.WatchedMovie
import java.util.UUID

@Dao
interface UserDao {
    @Query("SELECT EXISTS(SELECT 1 FROM user LIMIT 1)")
    fun isEmpty(): Boolean

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

    @Query("UPDATE WatchedMovie SET userRating = :userRating WHERE userId = :userId AND movieId = :movieId ")
    suspend fun updateUserRating(userId: UUID, movieId: Int, userRating: Int)

    @Query("UPDATE WatchedMovie SET diaryText = :diaryText WHERE userId = :userId AND movieId = :movieId ")
    suspend fun updateDiaryText(userId: UUID, movieId: Int, diaryText: String)

    @Query("SELECT movieId FROM WatchedMovie WHERE userId = :userId")
    suspend fun getListIdWatchedMovies(userId: UUID): List<Int>?

    @Query("SELECT * FROM WatchedMovie WHERE userId = :userId")
    suspend fun getListOfWatchedMovies(userId: UUID): List<WatchedMovie>?//для системы рекомендаций


    @Insert
    suspend fun addListOfMovies(listOfMovies: ListMovies)

    /*@Query("SELECT id FROM ListMovies WHERE userId = :userId")эти два запроса можно заменить нижним
    suspend fun getUUIDOfUsersLists(userId: UUID): List<UUID>?

    @Query("SELECT * FROM ListMovies WHERE id = :id")
    suspend fun getList(id: UUID): ListMovies?*/
    @Query("SELECT * FROM ListMovies WHERE userId = :userId")
    suspend fun getUserLists(userId: UUID): List<ListMovies>

    @Query("SELECT * FROM ListMovies WHERE id = :id")
    suspend fun getListOfMovies(id: UUID): ListMovies

    /*этот метод переносит обновленную строку вниз таблицы, поэтому сбивается порядок пользовательского списка
    @Insert(onConflict = OnConflictStrategy.REPLACE)//замена, если UUID одинаковый
    suspend fun saveListOfMovies(listOfMovies: ListMovies)*/

    //эти методы будут вместо целого saveListOfMovies, который работает не так, как хотелось бы
    @Query("UPDATE ListMovies SET title = :title WHERE id = :listId")
    suspend fun updateTitle(listId: UUID, title: String)

    @Query("UPDATE ListMovies SET moviesId = :moviesId WHERE id = :listId")
    suspend fun updateMovies(listId: UUID, moviesId: String)

    @Query("UPDATE ListMovies SET description = :description WHERE id = :listId")
    suspend fun updateDescription(listId: UUID, description: String)

    @Query("DELETE FROM ListMovies WHERE id = :id")
    suspend fun deleteListOfMovies(id: UUID)
}