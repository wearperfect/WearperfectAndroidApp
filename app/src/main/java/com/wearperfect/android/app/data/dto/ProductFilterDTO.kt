package com.wearperfect.android.app.data.dto

data class ProductFilterDTO (
    val searchText : String? = "",
    val categories: List<Int>? = listOf(),
    val colors: List<Int>? = listOf(),
    val brands: List<Int>? = listOf(),
    val designers: List<Int>? = listOf(),
    val manufacturerCategories: List<Short>? = listOf(),
    val genderCategories: List<Int>? = listOf(),
    val productCategories: List<Int>? = listOf(),
    val regions: List<Int>? = listOf(),
    val styles: List<Int>? = listOf(),
    val sizes: List<Short>? = listOf(),
)
