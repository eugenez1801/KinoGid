package com.example.kinogid.movies

object MovieCatalog{
    /*val actionGenre = Genre.ACTION.displayingGenre
    val adventureGenre = Genre.ADVENTURE.displayingGenre
    val animationGenre = Genre.ANIMATION.displayingGenre
    val biographyGenre = Genre.BIOGRAPHY.displayingGenre
    val comedyGenre = Genre.COMEDY.displayingGenre
    val crimeGenre = Genre.CRIME.displayingGenre
    val documentaryGenre = Genre.DOCUMENTARY.displayingGenre
    val dramaGenre = Genre.DRAMA.displayingGenre
    val familyGenre = Genre.FAMILY.displayingGenre
    val fantasyGenre = Genre.FANTASY.displayingGenre
    val horrorGenre = Genre.HORROR.displayingGenre
    val musicalGenre = Genre.MUSICAL.displayingGenre
    val mysteryGenre = Genre.MYSTERY.displayingGenre
    val romanceGenre = Genre.ROMANCE.displayingGenre
    val sctFiGenre = Genre.SCI_FI.displayingGenre
    val sportGenre = Genre.SPORT.displayingGenre
    val superheroGenre = Genre.SUPERHERO.displayingGenre
    val thrillerGenre = Genre.THRILLER.displayingGenre
    val warGenre = Genre.WAR.displayingGenre
    val westernGenre = Genre.WESTERN.displayingGenre*/
    val movieList = listOf(
        Movie(0, "Побег из Шоушенка", 1994, 144, "16+",
            setOf(Genre.DRAMA, Genre.CRIME), 9.3f, 9.1f, "Пусто"),
        Movie(1, "Крестный отец", 1972, 175, "16+",
            setOf(Genre.DRAMA, Genre.CRIME), 9.2f, 9.1f, "Пусто")
    )
}