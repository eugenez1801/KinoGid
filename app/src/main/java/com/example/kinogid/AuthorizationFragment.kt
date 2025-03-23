package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.kinogid.database.AppDatabase
import com.google.android.material.textfield.TextInputEditText

class AuthorizationFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val database = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "app_database"
        ).build()
        val userDao = database.userDao()
        val userRepository = UserRepository(userDao)
        val viewModel = AuthViewModel(userRepository)

        val view = inflater.inflate(R.layout.fragment_authorization, container, false)

        val registerText = view.findViewById<TextView>(R.id.registrationText)

        val loginInputText = view.findViewById<TextInputEditText>(R.id.login_input)
        val passwordInputText = view.findViewById<TextInputEditText>(R.id.password_input)
        val enterButton = view.findViewById<Button>(R.id.enter_button)

        registerText.setOnClickListener{
            val fragmentRegistration = RegistrationFragment.newInstance()

            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragmentRegistration)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        enterButton.setOnClickListener{
            viewModel.authenticateUser(loginInputText.text.toString(),
                passwordInputText.text.toString()){ success ->
                if(success) Toast.makeText(requireContext(), "Вход успешен!",
                    Toast.LENGTH_LONG).show()
                else Toast.makeText(requireContext(), "Указан неверный логин/пароль " +
                        "Проверьте данные",
                    Toast.LENGTH_LONG).show()
            }
        }
        return view
    }

    companion object {
        fun newInstance(): AuthorizationFragment {
            return AuthorizationFragment()
        }
    }
}