package com.example.kinogid

import com.example.kinogid.movies.Movie
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