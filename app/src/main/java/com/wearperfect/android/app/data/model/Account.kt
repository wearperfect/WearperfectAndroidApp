package com.wearperfect.android.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey()
    val username: String,
    val accessToken: String
)
