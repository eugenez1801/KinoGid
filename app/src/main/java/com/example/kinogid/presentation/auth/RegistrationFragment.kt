package com.example.kinogid.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.kinogid.R
import com.example.kinogid.data.repository.Repository
import com.example.kinogid.data.database.AppDatabase
import com.example.kinogid.utils.hideKeyboard
import com.google.android.material.textfield.TextInputEditText

class RegistrationFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val userDatabase = Room.databaseBuilder(
            requireContext().applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
        val userDao = userDatabase.userDao()
        val repository = Repository(userDao)
        val viewModel = AuthViewModel(repository)

        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        view.setOnTouchListener { view, motionEvent ->
            view.hideKeyboard()
            view.clearFocus()
            false
        }

        val enterText = view.findViewById<TextView>(R.id.enterText)

        val nameInputText = view.findViewById<TextInputEditText>(R.id.name_input)
        val loginInputText = view.findViewById<TextInputEditText>(R.id.login_input)
        val passwordInputText = view.findViewById<TextInputEditText>(R.id.password_input)
        val registerButton = view.findViewById<Button>(R.id.registration_button)

        enterText.setOnClickListener{
            moveToAuthorization()
        }

        registerButton.setOnClickListener{
            viewModel.registerUser(nameInputText.text.toString(),
                loginInputText.text.toString(),
                passwordInputText.text.toString()){ resultCode ->
                val registrationMessage = when(resultCode){
                    1 -> "Регистрация пользователя ${nameInputText.text.toString()} прошла успешно!"
                        .also { moveToAuthorization() }
                    2 -> "Такое имя пользователя уже занято!"
                    3 -> "Такой логин уже был использован для регистрации"
                    4 -> "Непредвиденная ошибка регистрации!"
                    5 -> "Заполните все необходимые поля для регистрации!"
                    6 -> "Длина пароля должна быть не менее 8 символов"
                    7 -> "Несуществующий логин. Проверьте введенные данные!"
                    else -> null
                }
                Toast.makeText(context, registrationMessage, Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun moveToAuthorization(){
        val authorizationFragment = AuthorizationFragment.newInstance()

        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, authorizationFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        fun newInstance(): RegistrationFragment {
            return RegistrationFragment()
        }
    }
}