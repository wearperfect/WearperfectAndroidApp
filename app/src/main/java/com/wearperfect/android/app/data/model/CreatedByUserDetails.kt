package com.wearperfect.android.app.data.model

data class CreatedByUserDetails(
    val active: Boolean,
    val fullname: String,
    val id: Int,
    val profileCoverPicture: String,
    val profilePicture: String,
    val username: String,
    val verified: Boolean
)