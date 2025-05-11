package com.example.kinogid.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinogid.data.repository.Repository
import com.example.kinogid.data.models.User
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
                if (isPasswordValid(password)){
                    if (isLoginValid(login)){
                        val user = User(name = name, login = login, password = password)
                        val resultCode = repository.addUser(user)
                        onResult(resultCode)
                    }
                    else onResult(7)//неверный логин
                }
                else onResult(6)//пароль должен быть длиной не менее 8 символов
            }
            /*НОВЫЙ РЕЗУЛЬТИРУЮЩИЙ КОД 5 - заполните все поля*/
            else onResult(5)
        }
    }

    fun isLoginValid(login: String): Boolean {
        val validSuffixes = listOf("@mail.ru", "@yandex.ru", "@ya.ru", "@bk.ru", "@inbox.ru",
            "@list.ru", "@rambler.ru")
        var cleanPhone = login.replace(" ", "").replace("-", "")

        //проверка на валидность электронки
        if (validSuffixes.any { login.endsWith(it) }){
            var checkingLogin = ""
            validSuffixes.firstOrNull{ login.endsWith(it) }?.let { suffix ->
                checkingLogin = login.removeSuffix(suffix)
            }

            if (!checkingLogin.startsWith(".") && !checkingLogin.endsWith(".")
                && !checkingLogin.contains("..") && checkingLogin.isNotEmpty()
                && (checkingLogin.all { it.isLetterOrDigit() || it in "!#\$%&'*+-/=?^_`{|}~." })) return true
            else return false
        }

        //проверка чисто номера телефона через cleanPhone, у которого удалены дефисы и пробелы
        else if (cleanPhone.length == 11 || cleanPhone.length == 12){
            if (cleanPhone.startsWith("+7") && cleanPhone.length == 12){
                cleanPhone = cleanPhone.replace("+", "")
                return cleanPhone.all { it.isDigit() }
            }
            else if (cleanPhone.startsWith("8") && cleanPhone.length == 11){
                return cleanPhone.all { it.isDigit() }
            }
            else return false
        }
        else return false
    }

    private fun isPasswordValid(password: String): Boolean{
        if (password.length >= 8) return true
        else return false
    }

    fun authenticateUser(login: String, password: String, onResult: (Boolean) -> Unit){
        viewModelScope.launch {
            if (repository.authenticate(login, password) != null) onResult(true)
            else onResult(false)
        }
    }
}