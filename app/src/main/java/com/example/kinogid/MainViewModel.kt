package com.example.kinogid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinogid.movies.Genre
import kotlinx.coroutines.launch
import java.util.UUID

class MainViewModel(private val userRepository: UserRepository): ViewModel() {
    val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user
    fun getUserByLogin(login: String){
        viewModelScope.launch {
            val user = userRepository.getUserByLogin(login)
            _user.postValue(user)
        }
    }

    val _userPrefences = MutableLiveData<UserPreferences?>()
    val userPreferences: LiveData<UserPreferences?> get() = _userPrefences
    fun getUserPreferences(/*userId: UUID*/)/*: UserPreferences?*/{//изначально передавал id
        viewModelScope.launch {
            val userPreferences = userRepository.getUserPreferences(user.value!!.id)//теперь берется из ViewModel id
            _userPrefences.postValue(userPreferences)
        }
    }

    fun updateSelectedGenres(genres: Set<Genre>) {
        val genresString = genres.joinToString(",") { it.name }
        viewModelScope.launch {
//            val genresString = genres.joinToString(",") { it.name }не нужно наверное (сверху есть)
            val userPreferences = user.value?.let {
                UserPreferences(
                    userId = it.id,
                    genres = genresString
                )
            }
            userRepository.saveUserPreferences(userPreferences!!)
            getUserPreferences()
            /*val newUserPreferences = userRepository.getUserPreferences(user.value!!.id)//теперь берется из ViewModel id
            _userPrefences.postValue(newUserPreferences)*/
        }
    }

    val _watchedMovie = MutableLiveData<WatchedMovie?>()
    val watchedMovie: LiveData<WatchedMovie?> get() = _watchedMovie
    fun getWatchedMovie(movieId: Int){ //нужен для начальной инициализации полей во фрагменте с деталями фильма
        viewModelScope.launch {
            val watchedMovie = userRepository.getWatchedMovie(user.value!!.id, movieId)
            _watchedMovie.postValue(watchedMovie)
        }
    }

    fun updateStatusWatchedMovie(movieId: Int, onResult: (Int) -> Unit){
        /*РЕЗУЛЬТИРУЮЩИЕ КОДЫ:
        * 1 - фильм был добавлен в список просмотренных
        * 2 - фильм был удален из списка просмотренных*/
        viewModelScope.launch {
            if (userRepository.getWatchedMovie(user.value!!.id, movieId) == null) {
                val watchedMovie = WatchedMovie(
                    userId = user.value!!.id,
                    movieId = movieId,
                    rating = null)
                userRepository.makeMovieIsWatched(watchedMovie)
                onResult(1)
            }
            else{
                userRepository.deleteWatchedMovie(user.value!!.id, movieId)
                onResult(2)
            }
            getWatchedMovie(movieId)
            getListWatchedMovies()//обновляем список после изменений в этом методе
        }
    }

    val _listWatchedMovies = MutableLiveData<List<Int>?>()
    val listWatchedMovies: LiveData<List<Int>?> get() = _listWatchedMovies
    fun getListWatchedMovies(){
        viewModelScope.launch {
            val listWatchedMovies = userRepository.getListWatchedMovies(user.value!!.id)
            _listWatchedMovies.postValue(listWatchedMovies)
        }
    }
}