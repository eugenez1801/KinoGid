package com.example.kinogid.domain.usecases

import com.example.kinogid.domain.recommendation.RecommendationEngine
import com.example.kinogid.data.repository.Repository
import com.example.kinogid.data.models.movies.Movie
import java.util.UUID

class GetRecommendationsUseCase(
    private val repository: Repository,
    private val recommendationEngine: RecommendationEngine
) {
    suspend fun getRecommendationList(userId: UUID): List<Movie>{
        val listWatchedMovies = repository.getListOfWatchedMovies(userId)
        val userPreferences = repository.getUserPreferences(userId)
        var recommendationList = listOf<Movie>()
        if (userPreferences != null && userPreferences.genres != "" && !listWatchedMovies.isNullOrEmpty()) {
            recommendationList = (recommendationEngine.makeRecommendationList(listWatchedMovies, userPreferences))
        }
        return recommendationList
    }
}