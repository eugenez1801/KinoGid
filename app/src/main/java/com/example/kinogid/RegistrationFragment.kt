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
        val userRepository = UserRepository(userDao)
        val registrationViewModel = RegistrationViewModel(userRepository)

        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        val enterText = view.findViewById<TextView>(R.id.enterText)

        val nameInputText = view.findViewById<TextInputEditText>(R.id.name_input)
        val loginInputText = view.findViewById<TextInputEditText>(R.id.login_input)
        val passwordInputText = view.findViewById<TextInputEditText>(R.id.password_input)
        val registerButton = view.findViewById<Button>(R.id.registration_button)

        enterText.setOnClickListener{
            val authorizationFragment = AuthorizationFragment.newInstance()

            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, authorizationFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        registerButton.setOnClickListener{
            registrationViewModel.registerUser(nameInputText.text.toString(),
                loginInputText.text.toString(),
                passwordInputText.text.toString()){ success ->
                if (success){
                    Toast.makeText(context, "Добро пожаловать в КиноГид, ${nameInputText.text.toString()}!",
                        Toast.LENGTH_LONG).show()
                }
                if (!success)Toast.makeText(context, "Произошла ошибка регистрации!",
                    Toast.LENGTH_LONG).show()
            }
        }
        return view
    }

    companion object {
        fun newInstance(): RegistrationFragment {
            return RegistrationFragment()
        }
    }
}