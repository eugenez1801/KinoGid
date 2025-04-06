package com.example.kinogid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinogid.movies.Genre
import kotlinx.coroutines.launch

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
        }
    }
}