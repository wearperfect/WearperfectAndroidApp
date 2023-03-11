package com.wearperfect.android.app.data.dto

data class ProductCategorySizeDTO(
    val id: Long,
    val productCategorySizeChartId: Int,
    val desc: String,
    val active: Boolean,
    val size: SizeDTO,
    val productCategorySizeMeasurements: List<ProductCategorySizeMeasurementDTO>,
)
