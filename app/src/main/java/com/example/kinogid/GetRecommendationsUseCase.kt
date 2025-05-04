package com.example.kinogid

import com.example.kinogid.movies.Movie
import java.util.UUID

class GetRecommendationsUseCase(
    private val userRepository: UserRepository,
    private val recommendationEngine: RecommendationEngine
) {
    suspend fun getRecommendationList(userId: UUID): List<Movie>{
        val listWatchedMovies = userRepository.getListOfWatchedMovies(userId)
        val userPreferences = userRepository.getUserPreferences(userId)
        var recommendationList = listOf<Movie>()
        if (userPreferences != null && userPreferences.genres != "" && !listWatchedMovies.isNullOrEmpty()) {
            recommendationList = (recommendationEngine.makeRecommendationList(listWatchedMovies, userPreferences))
        }
        return recommendationList
    }
}