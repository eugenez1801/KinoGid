package com.example.kinogid

import ViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.kinogid.database.AppDatabase

class RecommendationsFragment: Fragment() {
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val factory = ViewModelFactory(userRepository)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java] это создание
        новой ViewModel, нам это не нужно, мы должны использовать ту, что создалась в Activity*/
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_recommendations, container, false)
        val nameTextView = view.findViewById<TextView>(R.id.name_text)

        val user = viewModel.user.value
        nameTextView.text = "${user?.name}!"
        /*viewModel.user.observe(viewLifecycleOwner){user -> мы сделали observe в Activity
            nameTextView.text = "${user.name}!"
        }*/
        return view
    }

    companion object {
        fun newInstance(): RecommendationsFragment {
            return RecommendationsFragment()
        }
    }
}