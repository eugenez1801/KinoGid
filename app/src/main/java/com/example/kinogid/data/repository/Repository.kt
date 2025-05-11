package com.example.kinogid.data.repository

import com.example.kinogid.data.database.UserDao
import com.example.kinogid.data.models.ListMovies
import com.example.kinogid.data.models.User
import com.example.kinogid.data.models.UserPreferences
import com.example.kinogid.data.models.WatchedMovie
import java.util.UUID


class Repository(private val userDao: UserDao) {
    suspend fun isEmpty(): Boolean{
        return userDao.isEmpty()
    }

    suspend fun getUserByLogin(login: String): User?{
        return userDao.getUserByLogin(login)
    }

    suspend fun addUser(user: User): Int{
        /*РЕЗУЛЬТИРУЮЩИЕ КОДЫ:
        * 1 - успешное добавление пользователя
        * 2 - имя занято
        * 3 - логин занят
        * 4 - ?непредвиденная? ошибка регистрации*/
        if (userDao.getUserByName(user.name) != null) return 2
        if (userDao.getUserByLogin(user.login) != null) return 3
        try {
            userDao.addUser(user)
            return 1
        } catch (e: Exception){
            return 4
        }
    }

    suspend fun authenticate(login: String, password: String): User?{
        return userDao.getUserByLoginAndPassword(login, password)
    }


    suspend fun saveUserPreferences(preferences: UserPreferences){
        return userDao.savePreferences(preferences)
    }

    suspend fun getUserPreferences(userId: UUID): UserPreferences?{/*тут обязательно ? нужен,
    поскольку при первом запуске у нового пользователя не существует своих UserPreferences*/
        return userDao.getPreferences(userId)
    }


    suspend fun makeMovieIsWatched(watchedMovie: WatchedMovie){
        return userDao.makeMovieIsWatched(watchedMovie)
    }

    suspend fun getWatchedMovie(userId: UUID, movieId: Int): WatchedMovie?{
        return userDao.getWatchedMovie(userId, movieId)
    }

    suspend fun deleteWatchedMovie(userId: UUID, movieId: Int){
        return userDao.deleteWatchedMovie(userId, movieId)
    }

    suspend fun updateUserRating(userId: UUID, movieId: Int, userRating: Int){
        return userDao.updateUserRating(userId, movieId, userRating)
    }

    suspend fun updateDiaryText(userId: UUID, movieId: Int, diaryText: String){
        return userDao.updateDiaryText(userId, movieId, diaryText)
    }

    suspend fun getListIdWatchedMovies(userId: UUID): List<Int>?{
        return userDao.getListIdWatchedMovies(userId)
    }

    suspend fun getListOfWatchedMovies(userId: UUID): List<WatchedMovie>?{
        return userDao.getListOfWatchedMovies(userId)
    }


    suspend fun addListOfMovies(listOfMovies: ListMovies){
        return userDao.addListOfMovies(listOfMovies)
    }

    suspend fun getUserLists(userId: UUID): List<ListMovies>{
        return userDao.getUserLists(userId)
    }

    suspend fun getListOfMovies(listId: UUID): ListMovies {
        return userDao.getListOfMovies(listId)
    }

    /*suspend fun saveListOfMovies(listOfMovies: ListMovies){ отвергнут этот путь
        return userDao.saveListOfMovies(listOfMovies)
    }*/
    suspend fun updateTitle(listId: UUID, title: String){
        return userDao.updateTitle(listId, title)
    }

    suspend fun updateMovies(listId: UUID, moviesId: String){
        return userDao.updateMovies(listId, moviesId)
    }

    suspend fun updateDescription(listId: UUID, description: String){
        return userDao.updateDescription(listId, description)
    }

    suspend fun deleteListOfMovies(listId: UUID){
        return userDao.deleteListOfMovies(listId)
    }
}