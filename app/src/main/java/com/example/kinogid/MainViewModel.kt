package com.example.kinogid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinogid.movies.Genre
import com.example.kinogid.movies.Movie
import kotlinx.coroutines.launch
import java.util.UUID

class MainViewModel(
    private val repository: Repository,
    private val recommendationUseCase: GetRecommendationsUseCase
): ViewModel() {
    val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user
    fun getUserByLogin(login: String){
        viewModelScope.launch {
            val user = repository.getUserByLogin(login)
            _user.postValue(user)
        }
    }

    val _userPrefences = MutableLiveData<UserPreferences?>()
    val userPreferences: LiveData<UserPreferences?> get() = _userPrefences
    fun getUserPreferences(/*userId: UUID*/)/*: UserPreferences?*/{//изначально передавал id
        viewModelScope.launch {
            val userPreferences = repository.getUserPreferences(user.value!!.id)//теперь берется из ViewModel id
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
            repository.saveUserPreferences(userPreferences!!)
            getUserPreferences()
            /*val newUserPreferences = userRepository.getUserPreferences(user.value!!.id)//теперь берется из ViewModel id
            _userPrefences.postValue(newUserPreferences)*/
        }
    }

    val _watchedMovie = MutableLiveData<WatchedMovie?>()
    val watchedMovie: LiveData<WatchedMovie?> get() = _watchedMovie
    fun getWatchedMovie(movieId: Int){ //нужен для начальной инициализации полей во фрагменте с деталями фильма
        viewModelScope.launch {
            val watchedMovie = repository.getWatchedMovie(user.value!!.id, movieId)
            _watchedMovie.postValue(watchedMovie)
        }
    }

    fun updateStatusWatchedMovie(movieId: Int, onResult: (Int) -> Unit){
        /*РЕЗУЛЬТИРУЮЩИЕ КОДЫ:
        * 1 - фильм был добавлен в список просмотренных
        * 2 - фильм был удален из списка просмотренных*/
        viewModelScope.launch {
            if (repository.getWatchedMovie(user.value!!.id, movieId) == null) {
                val watchedMovie = WatchedMovie(
                    userId = user.value!!.id,
                    movieId = movieId)
                repository.makeMovieIsWatched(watchedMovie)
                onResult(1)
            }
            else{
                repository.deleteWatchedMovie(user.value!!.id, movieId)
                onResult(2)
            }
            getWatchedMovie(movieId)
            getListIdWatchedMovies()//обновляем список после изменений в этом методе
        }
    }

    fun updateUserRating(movieId: Int, userRating: Int){
        viewModelScope.launch {
            repository.updateUserRating(user.value!!.id, movieId, userRating)
        }
    }

    fun updateDiaryText(movieId: Int, diaryText: String){
        viewModelScope.launch {
            repository.updateDiaryText(user.value!!.id, movieId, diaryText)
        }
    }

    val _listWatchedMovies = MutableLiveData<List<Int>?>()
    val listWatchedMovies: LiveData<List<Int>?> get() = _listWatchedMovies
    fun getListIdWatchedMovies(){
        viewModelScope.launch {
            val listWatchedMovies = repository.getListIdWatchedMovies(user.value!!.id)
            _listWatchedMovies.postValue(listWatchedMovies)
        }
    }


    fun createNewListOfMovies(title: String, moviesId: String, description: String){
        viewModelScope.launch {
            val listMovies = ListMovies(
                userId = user.value!!.id,
                title = title,
                moviesId = moviesId,
                description = description)
            repository.addListOfMovies(listMovies)
        }
    }

    val _listOfListsMovies = MutableLiveData<List<ListMovies>>()
    val listOfListsMovies: LiveData<List<ListMovies>> get() = _listOfListsMovies
    fun getUserLists(){
        viewModelScope.launch {
            val listOfListsMovies = repository.getUserLists(user.value!!.id)
            _listOfListsMovies.postValue(listOfListsMovies)
        }
    }

    val _listOfMovies = MutableLiveData<ListMovies?>()
    val listOfMovies: LiveData<ListMovies?> get() = _listOfMovies
    fun getListOfMovies(listId: UUID){
        _listOfMovies.postValue(null)
        viewModelScope.launch {
            val listOfMovies = repository.getListOfMovies(listId)
            _listOfMovies.postValue(listOfMovies)
        }
    }
    fun clearListOfMovies() {
        _listOfMovies.value = null
    }

    /*fun saveListOfMovies(listOfMovies: ListMovies){ отвергнут этот способ (причина в DAO)
        viewModelScope.launch {
            userRepository.saveListOfMovies(listOfMovies)
        }
    }*/
    fun updateTitle(listId: UUID, title: String){
        viewModelScope.launch {
            repository.updateTitle(listId, title)
        }
    }

    fun updateMovies(listId: UUID, moviesId: String){
        viewModelScope.launch {
            repository.updateMovies(listId, moviesId)
        }
    }

    fun updateDescription(listId: UUID, description: String){
        viewModelScope.launch {
            repository.updateDescription(listId, description)
        }
    }

    fun deleteListOfMovies(listId: UUID){
        viewModelScope.launch {
            repository.deleteListOfMovies(listId)
        }
    }


    //система рекомендаций
    val _listOfRecommendation = MutableLiveData<List<Movie>>()
    val listOfRecommendation: LiveData<List<Movie>> get() = _listOfRecommendation
    fun updateListOfRecommendation(){
        viewModelScope.launch {
            val listOfRecommendation = recommendationUseCase.getRecommendationList(user.value!!.id)
            _listOfRecommendation.postValue(listOfRecommendation)
        }
    }
}