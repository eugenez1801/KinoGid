package com.example.kinogid.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.kinogid.presentation.main.MainActivity
import com.example.kinogid.utils.PreferencesManager
import com.example.kinogid.R
import com.example.kinogid.utils.hideKeyboard
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class AuthorizationFragment: Fragment() {
    private lateinit var preferencesManager: PreferencesManager
    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]

        preferencesManager = PreferencesManager(requireContext())

        val view = inflater.inflate(R.layout.fragment_authorization, container, false)
        view.setOnTouchListener { view, motionEvent ->
            view.hideKeyboard()
            view.clearFocus()
            false
        }

        val registerText = view.findViewById<TextView>(R.id.registrationText)

        val loginInputText = view.findViewById<TextInputEditText>(R.id.login_input)
        val passwordInputText = view.findViewById<TextInputEditText>(R.id.password_input)
        val enterButton = view.findViewById<Button>(R.id.enter_button)
        val rememberMeCheckBox = view.findViewById<CheckBox>(R.id.remember_me)

        registerText.setOnClickListener{
            val fragmentRegistration = RegistrationFragment.newInstance()

            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, fragmentRegistration)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        enterButton.setOnClickListener{
            viewModel.authenticateUser(loginInputText.text.toString(),
                passwordInputText.text.toString()){ success ->
                if(success) {
                    if (rememberMeCheckBox.isChecked){
                        lifecycleScope.launch {
                            preferencesManager.saveUserSession(loginInputText.text.toString(), true)
                            /*viewModel.getUserByLogin(loginInputText.text.toString())
                            это было нужно, если бы UUID записывали вместо логина, но обойдемся
                            просто логином, ведь он тоже уникальный и меньше новых функций для
                            преобразований нужно
                            viewModel.user.observe(viewLifecycleOwner){
                                lifecycleScope.launch {
                                    preferencesManager.saveUserSession(it!!.id, true)
                                }
                            }*/
                        }
                    }

                    Toast.makeText(
                        requireContext(), "Вход успешен!",
                        Toast.LENGTH_LONG
                    ).show()
                    val intent: Intent//заменил в AuthActivity collect на first, поэтому явный вызов отсюда остался
                    intent =
                        MainActivity.newIntent(requireContext(), loginInputText.text.toString())
                    startActivity(intent)
                    requireActivity().finish()
                }
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