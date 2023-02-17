package com.wearperfect.android.app.data.model

data class UserRegistrationData(
    val username: String,
    val password: String,
    val email: String? = null,
    val phone: String? = null,
    val fullname: String
)
