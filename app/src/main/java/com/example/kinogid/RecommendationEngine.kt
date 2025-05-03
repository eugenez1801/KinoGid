package com.example.kinogid

import com.example.kinogid.movies.Genre
import com.example.kinogid.movies.Movie
import com.example.kinogid.movies.MovieCatalog

/*
class RecommendationEngine {
    fun makeRecommendationList(
        listOfWatchedMovie: List<WatchedMovie>,
        userPreferences: UserPreferences
    ): List<Movie>{
        val genrePoints = Genre.entries.associate { it to 0 }.toMutableMap()
        */
/*val movieById = MovieCatalog.movieList.associateBy { it.id }находится в каталоге, чтобы каждый раз не создавать заново*//*

        for (watchedMovie in listOfWatchedMovie){
//            val currentMovie = MovieCatalog.movieList[watchedMovie.movieId] лучше нижний вариант
            val currentMovie = MovieCatalog.movieById[watchedMovie.movieId]!!
            genrePoints.forEach { (genre, points) ->
                if (genre in currentMovie.genres)
            }
        }
    }
}*/
