package com.example.kinogid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: Repository): ViewModel() {
    suspend fun isEmpty(): Boolean{
        return repository.isEmpty()
    }

    /*Параметр resultCode — это результат операции, который передается из ViewModel в UI-слой
    (фрагмент/активность) через callback.*/
    fun registerUser(name: String, login: String, password: String, onResult: (Int) -> Unit){
        viewModelScope.launch {
            if (name.isNotBlank() && login.isNotBlank() and password.isNotBlank()){
                val user = User(name = name, login = login, password = password)
                val resultCode = repository.addUser(user)
                onResult(resultCode)
            }
            /*НОВЫЙ РЕЗУЛЬТИРУЮЩИЙ КОД 5 - заполните все поля*/
            else onResult(5)
        }
    }

    fun authenticateUser(login: String, password: String, onResult: (Boolean) -> Unit){
        viewModelScope.launch {
            if (repository.authenticate(login, password) != null) onResult(true)
            else onResult(false)
        }
    }
}