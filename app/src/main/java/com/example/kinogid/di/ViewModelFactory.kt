package com.example.kinogid.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kinogid.domain.usecases.GetRecommendationsUseCase
import com.example.kinogid.presentation.main.MainViewModel
import com.example.kinogid.data.repository.Repository

class ViewModelFactory(
    private val repository: Repository,
    private val recommendationUseCase: GetRecommendationsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, recommendationUseCase) as T
    }
}