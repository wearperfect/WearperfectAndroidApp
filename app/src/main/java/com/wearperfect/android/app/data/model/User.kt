package com.wearperfect.android.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: Long,
    val username: String,
    val fullname: String,
    val bio: String,
    val cityId: Int,
    val countryId: Int,
    val createdOn: Long,
    val currentAddressId: Int,
    val deliveryAddressId: Int,
    val dob: Long,
    val email: String,
    val following: Boolean,
    val genderId: Int,
    val homeAddressId: Int,
    val lastUpdatedOn: Long,
    val phone: String,
    val profileCoverPicture: String,
    val profilePicture: String,
    val roleId: Int,
    val stateId: Int,
    val verified: Boolean,
    val verifiedEmail: Boolean,
    val verifiedPhone: Boolean,
    val website: String,
    val active: Boolean
)