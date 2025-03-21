package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AuthorizationFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_authorization, container, false)
        val registerText = view.findViewById<TextView>(R.id.registrationText)

        registerText.setOnClickListener{
            val fragmentRegistration = RegistrationFragment.newInstance()

            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragmentRegistration)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }

    companion object {
        fun newInstance(): AuthorizationFragment {
            return AuthorizationFragment()
        }
    }
}