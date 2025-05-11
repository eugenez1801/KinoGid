package com.example.kinogid.domain.recommendation

import com.example.kinogid.data.models.UserPreferences
import com.example.kinogid.data.models.WatchedMovie
import com.example.kinogid.data.models.movies.MovieCatalog
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.UUID

class RecommendationEngineTest {
    private lateinit var recommendationEngine: RecommendationEngine

    @Before
    fun setup() {
        MovieCatalog.movieList = TestMovieCatalog.movieList
        MovieCatalog.movieById = TestMovieCatalog.movieById
        recommendationEngine = RecommendationEngine()
    }

    @Test
    fun  testMakeRecommendationListReturnsCorrectRecommendations() {
        val userId = UUID.randomUUID()

        val watchedMovies = listOf(
            WatchedMovie(userId = userId, movieId = 61, userRating = 2)
        )

        val userPreferences = UserPreferences(userId = userId, genres = "DRAMA")

        val recommendations = recommendationEngine.makeRecommendationList(watchedMovies, userPreferences)

        //должен вывести 47, поскольку фильмов в жанре драма всего 48, а так как Сансет Бульвар (61)
        //уже просмотрен, то в список рекомендаций он не идет
        assertEquals(47, recommendations.size)

        assertEquals(false, "Сансет бульвар" in recommendations.toString())

        assertEquals(true, "Побег из Шоушенка" in recommendations.toString())


        //теперь пусть пользователю не понравился фильм Сансет Бульвар(61)
        val watchedMovies2 = listOf(
            WatchedMovie(userId = userId, movieId = 61, userRating = 3)
        )

        //так как DRAMA не получила очков из-за непонравившегося Сансет Бульвар, список должен быть пустой
        val recommendations2 = recommendationEngine.makeRecommendationList(watchedMovies2, userPreferences)
        assertEquals(0, recommendations2.size)
    }
}