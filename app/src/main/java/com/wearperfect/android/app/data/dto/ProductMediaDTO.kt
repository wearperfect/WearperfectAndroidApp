package com.wearperfect.android.app.data.dto

data class ProductMediaDTO (
    val id: Long,
    val productId: Long,
    val title: String,
    val desc: String,
    val sequenceId: Byte,
    val sourceLink: String,
    val active: Boolean,
    val contentType: ContentTypeDTO
)
