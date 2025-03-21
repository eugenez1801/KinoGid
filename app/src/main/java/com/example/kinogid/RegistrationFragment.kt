package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

class RegistrationFragment: Fragment() {
    private val registrationViewModel: RegistrationViewModel by lazy {
        ViewModelProvider(this).get(RegistrationViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        val enterText = view.findViewById<TextView>(R.id.enterText)

        val registrationText = view.findViewById<TextView>(R.id.registration)
        /*val loginInputText = view.findViewById<TextInputLayout>(R.id.login) чтобы считать текст
        * нужно обращаться к TextInputEditText а не Layout*/
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
            /*var userName: String = nameInputText.text.toString() *//*Просто для тренировки*//*
            var userLogin: String = loginInputText.text.toString()
            var userPassword: String = passwordInputText.text.toString()
            registrationText.text = "$userName $userLogin $userPassword"*/
            registrationViewModel.addNewUser(nameInputText.text.toString(),
                loginInputText.text.toString(),
                passwordInputText.text.toString())
        }

        registrationViewModel.toastMessage.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
        return view
    }

    companion object {
        fun newInstance(): RegistrationFragment {
            return RegistrationFragment()
        }
    }
}