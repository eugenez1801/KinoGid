package com.example.kinogid

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.kinogid.movies.Genre

fun normalizeDuration(duration: Int): String{
    if (duration < 60) return "${duration.toString()} мин"
    val hours = duration / 60
    val minutes = duration % 60
    return ("$hours ч $minutes мин ")
}

fun normalizeGenres(genres: Set<Genre>): String{
    var result = ""
    if(Genre.ACTION in genres) result += "${Genre.ACTION.displayingGenre}, "
    if(Genre.ADVENTURE in genres) result += "${Genre.ADVENTURE.displayingGenre}, "
    if(Genre.ANIMATION in genres) result += "${Genre.ANIMATION.displayingGenre}, "
    if(Genre.BIOGRAPHY in genres) result += "${Genre.BIOGRAPHY.displayingGenre}, "
    if(Genre.COMEDY in genres) result += "${Genre.COMEDY.displayingGenre}, "
    if(Genre.CRIME in genres) result += "${Genre.CRIME.displayingGenre}, "
    if(Genre.DOCUMENTARY in genres) result += "${Genre.DOCUMENTARY.displayingGenre}, "
    if(Genre.DRAMA in genres) result += "${Genre.DRAMA.displayingGenre}, "
    if(Genre.FAMILY in genres) result += "${Genre.FAMILY.displayingGenre}, "
    if(Genre.FANTASY in genres) result += "${Genre.FANTASY.displayingGenre}, "
    if(Genre.HORROR in genres) result += "${Genre.HORROR.displayingGenre}, "
    if(Genre.MUSICAL in genres) result += "${Genre.MUSICAL.displayingGenre}, "
    if(Genre.MYSTERY in genres) result += "${Genre.MYSTERY.displayingGenre}, "
    if(Genre.ROMANCE in genres) result += "${Genre.ROMANCE.displayingGenre}, "
    if(Genre.SCI_FI in genres) result += "${Genre.SCI_FI.displayingGenre}, "
    if(Genre.SPORT in genres) result += "${Genre.SPORT.displayingGenre}, "
    if(Genre.SUPERHERO in genres)result += "${Genre.SUPERHERO.displayingGenre}, "
    if(Genre.THRILLER in genres) result += "${Genre.THRILLER.displayingGenre}, "
    if(Genre.WAR in genres) result += "${Genre.WAR.displayingGenre}, "
    if(Genre.WESTERN in genres) result += "${Genre.WESTERN.displayingGenre}, "
    result = result.removeSuffix(", ")
    return result
}

//не MovieFormat. Прячет клавиатуру, когда кликают в рандомное место
fun View.hideKeyboard() {//функция-расширение (extension function), поэтому View.
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}