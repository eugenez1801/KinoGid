package com.example.kinogid

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(foreignKeys = [ForeignKey(
    entity = User::class,
    parentColumns = ["id"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE
    )]
)
data class WatchedMovie(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    val movieId: Int,
    val userRating: Int = 1,//пусть по умолчанию - нейтральное
    val diaryText: String = ""
)