package com.example.kinogid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ProfileFragment: Fragment() {
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val user = viewModel.user.value!!

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val nameField = view.findViewById<TextView>(R.id.name_field)
        nameField.text = "Имя: ${user.name}"
        return view
    }
}