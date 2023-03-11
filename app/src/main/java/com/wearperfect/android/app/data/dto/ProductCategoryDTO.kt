package com.wearperfect.android.app.data.dto

data class ProductCategoryDTO (
    val id: Int,
    val name: String,
    val desc: String,
    val thumbnail: String,
    val sourceLink: String,
    val sequence: Int,
    val active: Boolean,
    val category: CategoryDTO,
)
