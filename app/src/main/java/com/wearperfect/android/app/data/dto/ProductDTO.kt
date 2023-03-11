package com.wearperfect.android.app.data.dto

data class ProductDTO(
    val id: Long,
    val name: String,
    val description: String,
    val features: String,
    val availableForSale: Boolean,
    val price: Float,
    val discount: Int,
    val discountTypeId: Int,
    val currencyId: Int,
    val createdOn: String,
    val lastUpdatedOn: String,
    val active: Boolean,
    val currency: CurrencyDTO,
    val manufacturer: UserDTO,
    val productCategory: ProductCategoryDTO,
    val genderCategory: GenderCategoryDTO,
    val color: ColorDTO,
    val productMediaList: List<ProductMediaDTO>,
    val productStyles: List<ProductStyleDTO>,
    val productInventoryItems: List<ProductInventoryItemDTO>,
    val productCategorySizeChart: ProductCategorySizeChartDTO,
    val productSpecialSizeChart: ProductSpecialSizeChartDTO
)
