package com.example.kinogid

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class User(@PrimaryKey val id: UUID = UUID.randomUUID(),
    var name: String = "",
    var login: String = "",
    var password: String = "")
