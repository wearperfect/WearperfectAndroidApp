package com.wearperfect.android.app.data.dto

data class ProductSpecialSizeMeasurementDTO(
    val id: Long,
    val productSpecialSizeId: Long,
    val value: Float,
    val active: Boolean,
    val productMeasurementLabel: ProductMeasurementLabelDTO,
    val measurementUnit: MeasurementUnitDTO
)
