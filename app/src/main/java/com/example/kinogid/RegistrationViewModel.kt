package com.example.kinogid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegistrationViewModel(private val userRepository: UserRepository): ViewModel() {
/*Параметр success — это результат операции, который передается из ViewModel в UI-слой
(фрагмент/активность) через callback.*/
    fun registerUser(name: String, login: String, password: String, onResult: (Boolean) -> Unit){
        viewModelScope.launch {
            if (name.isNotBlank() && login.isNotBlank() and password.isNotBlank()){
                val user = User(name = name, login = login, password = password)
                val success = userRepository.addUser(user)
                onResult(success)
            }
            else onResult(false)
        }
    }


}