package com.example.kinogid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository): ViewModel() {
    val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun getUserByLogin(login: String){
        viewModelScope.launch {
            val user = userRepository.getUserByLogin(login)
            _user.postValue(user)
        }
    }
}