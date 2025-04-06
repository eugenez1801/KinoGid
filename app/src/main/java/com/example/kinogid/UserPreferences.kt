package com.example.kinogid

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.kinogid.movies.Genre
import java.util.UUID

@Entity(foreignKeys = [ForeignKey(
    entity = User::class,
    parentColumns = ["id"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE,
    )]
)

data class UserPreferences(
//    @PrimaryKey val id: UUID = UUID.randomUUID(), решил работать по userId
    @PrimaryKey val userId: UUID,
//    val genres: Set<Genre> сложно
    val genres: String
)