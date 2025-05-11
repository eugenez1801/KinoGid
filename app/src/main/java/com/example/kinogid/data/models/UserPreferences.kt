package com.example.kinogid.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(foreignKeys = [ForeignKey(
    entity = User::class,
    parentColumns = ["id"],//ссылается на id у User, а не UserPreferences
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