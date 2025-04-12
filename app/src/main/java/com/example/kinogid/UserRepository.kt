package com.example.kinogid

import com.example.kinogid.database.UserDao
import java.util.UUID


class UserRepository(private val userDao: UserDao) {
    fun getUser(id: UUID): User{ //LiveData<User?>
        return userDao.getUser(id)
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

    /*suspend fun updateStatusWatchedMovie(userId: UUID, movieId: Int){ не пригодилось,
    или не додумал (минуты 3 думал всего)
        if (userDao.getWatchedMovie(userId, movieId) != null) userDao.makeMovieIsWatched()
    }*/
}