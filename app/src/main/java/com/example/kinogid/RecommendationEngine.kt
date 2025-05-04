package com.example.kinogid

import com.example.kinogid.movies.Genre
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog
import kotlin.math.round

class RecommendationEngine {
    fun makeRecommendationList(
        listOfWatchedMovie: List<WatchedMovie>,
        userPreferences: UserPreferences
    ): List<Movie> {
//        Log.d("Chekau", "Просмотренный список: ${listOfWatchedMovie.toString()}")
//        Log.d("Chekau", "UserPreferences: ${userPreferences.toString()}")
        val genrePoints =
            Genre.entries.associateWith { /*it to это если без With*/ 0 }.toMutableMap()
        for (watchedMovie in listOfWatchedMovie) {//разборка со списком просмотренных фильмов
//            val currentMovie = MovieCatalog.movieList[watchedMovie.movieId] лучше нижний вариант
            val currentMovie = MovieCatalog.movieById[watchedMovie.movieId]!!
            genrePoints.forEach { (genre, points) ->
                if (genre in currentMovie.genres) {
                    when (watchedMovie.userRating) {
                        1 -> genrePoints[genre] = points + 2//нейтрально
                        2 -> genrePoints[genre] = points + 3//лайк
                        3 -> genrePoints[genre] = points /*наверное за дизлайк лучше ничего не давать*/
                    }
                }
            }
        }

        //разборка с предпочтениями пользователя (любимые жанры). Будет давать множитель жанру, вместо старого +5.
        genrePoints.forEach { (genre, points) ->
            if (genre.toString() in userPreferences.genres)
                genrePoints[genre] = (points * 1.5).toInt()
        }

        //генерация списка рекомендаций
        var recommendationMap = mutableMapOf<Int, Double>()
        for (movie in MovieCatalog.movieList) {
            if (movie.id !in listOfWatchedMovie.map { it.movieId }) {
                var moviePoints = 0
                val averageRating = (movie.rateIMDB + movie.rateKinopoisk) / 2
                val ratingsFactor = when {
                    averageRating < 5.0 -> 0.0
                    averageRating > 8.5 -> 1.0
                    else -> averageRating / 10.0
                }

                genrePoints.forEach { (genre, points) ->
                    if (genre in movie.genres) moviePoints += points
                }

                if (moviePoints > 0){
                    recommendationMap[movie.id] =
                        round(moviePoints * ratingsFactor * 1000) / 1000.0//округление до 3 знака
                }
            }
        }
        recommendationMap = recommendationMap.entries
            .sortedBy { it.value }.reversed()
            .associate { it.toPair() }.toMutableMap()

        val recommendationList = mutableListOf<Movie>()
        for (movieMap in recommendationMap) {
            recommendationList.add(MovieCatalog.movieById[movieMap.key]!!)
        }

        return (recommendationList)
//        Log.d("Chekau", "Список отправленный из системы рекомендаций: ${recommendationList}")
    }
}