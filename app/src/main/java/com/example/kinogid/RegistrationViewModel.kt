package com.example.kinogid

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel() {
    val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    fun addNewUser(name: String, login: String, password: String){
        /*Toast.makeText(context, "Welcome, $name. U r login is $login. U r password is $password",
         Toast.LENGTH_LONG).show() Так нельзя, потому что В архитектуре MVVM ViewModel не
         должна напрямую взаимодействовать с UI (например, показывать Toast). Вместо этого ViewModel
         должна сообщать Fragment о необходимости показать Toast через LiveData*/
        _toastMessage.value = "Welcome, $name. U r login is $login. U r password is $password"
    }
}