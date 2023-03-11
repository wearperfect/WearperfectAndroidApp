package com.wearperfect.android.app.data.dto

data class ProductSpecialSizeChartDTO (
    val id: Long,
    val productId: Long,
    val desc: String,
    val active: Boolean,
    val productSpecialSizes: List<ProductSpecialSizeDTO>,
)
