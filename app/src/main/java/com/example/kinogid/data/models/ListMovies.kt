package com.example.kinogid.data.models

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
data class ListMovies(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    var title: String,
    var moviesId: String,//пока так...
    var description: String = ""
)