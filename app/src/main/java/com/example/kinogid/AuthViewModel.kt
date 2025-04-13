package com.example.kinogid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val userRepository: UserRepository): ViewModel() {
    /*Параметр resultCode — это результат операции, который передается из ViewModel в UI-слой
    (фрагмент/активность) через callback.*/
    fun registerUser(name: String, login: String, password: String, onResult: (Int) -> Unit){
        viewModelScope.launch {
            if (name.isNotBlank() && login.isNotBlank() and password.isNotBlank()){
                val user = User(name = name, login = login, password = password)
                val resultCode = userRepository.addUser(user)
                onResult(resultCode)
            }
            /*НОВЫЙ РЕЗУЛЬТИРУЮЩИЙ КОД 5 - заполните все поля*/
            else onResult(5)
        }
    }

    fun authenticateUser(login: String, password: String, onResult: (Boolean) -> Unit){
        viewModelScope.launch {
            if (userRepository.authenticate(login, password) != null) onResult(true)
            else onResult(false)
        }
    }

    val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user
    fun getUserByLogin(login: String){
        viewModelScope.launch {
            val user = userRepository.getUserByLogin(login)
            _user.postValue(user)
        }
    }
}