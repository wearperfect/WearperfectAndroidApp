package com.wearperfect.android.app.data.repository

import com.wearperfect.android.app.data.dto.ProductDTO
import com.wearperfect.android.app.data.dto.ProductFilterDTO
import com.wearperfect.android.app.data.service.ProductService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService
) {
    suspend fun getFilteredProducts(
        productFilter: ProductFilterDTO, page: Int, size: Int
    ): List<ProductDTO> {
        return productService.getFilteredProducts(productFilter, page, size)
    }
}