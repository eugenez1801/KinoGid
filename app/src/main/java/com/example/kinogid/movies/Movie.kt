package com.example.kinogid.movies

data class Movie(
    val id: Int,
    val title: String,
    var year: Int,
    var duration: Int,//в минутах
    var ageRating: String,
    val genres: Set<Genre>,
    val rateIMDB: Float,
    val rateKinopoisk: Float,
    val description: String
)