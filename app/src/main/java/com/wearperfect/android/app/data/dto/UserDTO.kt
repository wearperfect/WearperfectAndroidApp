package com.wearperfect.android.app.data.dto

data class UserDTO (
    val id: Long,
    val username: String,
    val fullname: String,
    val profilePicture: String,
    val profileCoverPicture: String,
    val verified: Boolean,
    val active: Boolean
)
