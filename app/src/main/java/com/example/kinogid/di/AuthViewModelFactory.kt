package com.example.kinogid.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kinogid.data.database.AppDatabase
import com.example.kinogid.data.repository.Repository
import com.example.kinogid.presentation.auth.AuthViewModel

class AuthViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val database = AppDatabase.getInstance(context/*.applicationContext нет необходимости*/)
        val userDao = database.userDao()
        val repository = Repository(userDao)

        return AuthViewModel(repository) as T
    }
}