package com.example.kinogid.data.database

import androidx.room.TypeConverter
import com.example.kinogid.data.models.movies.Genre
import java.util.UUID

class UserTypeConverters {
    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }

    /*@TypeConverter
    fun fromGenres(genres: Set<Genre>): String{
        return genres.joinToString { it.name }
    }
    @TypeConverter
    fun toGenreSet(data: String): Set<Genre> {
        return if (data.isEmpty()) emptySet()
        else data.split(",")
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .map { Genre.valueOf(it) } // Используем valueOf для enum
            .toSet()
    }хотелось через Set, но передумал*/
}