package com.wearperfect.android.app.data.dto

data class ProductCategorySizeChartDTO (
    val id: Int,
    val desc: String,
    val active: Boolean,
    val productCategorySizes: List<ProductCategorySizeDTO>
)
