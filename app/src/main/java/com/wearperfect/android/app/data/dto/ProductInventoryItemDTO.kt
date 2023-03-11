package com.wearperfect.android.app.data.dto

data class ProductInventoryItemDTO (
    val id: Long,
    val productId: Long,
    val sizeId: Int,
    val warehouseId: Int,
    val quantityInStock: Int,
    val active: Boolean,
    val size: SizeDTO
)
