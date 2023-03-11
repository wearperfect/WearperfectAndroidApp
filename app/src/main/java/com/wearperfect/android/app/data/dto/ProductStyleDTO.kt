package com.wearperfect.android.app.data.dto

data class ProductStyleDTO(
    val id: Long,
    val productId: Long,
    val active: Boolean,
    val style: StyleDTO
)
