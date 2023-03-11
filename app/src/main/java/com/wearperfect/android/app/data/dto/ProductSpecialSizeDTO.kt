package com.wearperfect.android.app.data.dto

data class ProductSpecialSizeDTO(
    val id: Long,
    val sizeId: Short,
    val productSpecialSizeChartId: Long,
    val desc: String,
    val active: Boolean,
    val size: SizeDTO,
    val productSpecialSizeMeasurements: List<ProductSpecialSizeMeasurementDTO>,
)
