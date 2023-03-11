package com.wearperfect.android.app.data.dto

data class ProductCategorySizeMeasurementDTO (
    val id: Int,
    val productCategorySizeId: Long,
    val value: Float,
    val active: Boolean,
    val productMeasurementLabel: ProductMeasurementLabelDTO,
    val measurementUnit: MeasurementUnitDTO
)
