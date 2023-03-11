package com.wearperfect.android.app.data.service

import com.wearperfect.android.app.data.dto.ProductDTO
import com.wearperfect.android.app.data.dto.ProductFilterDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ProductService {

    @GET("/v1/products")
    suspend fun getProducts()

    @POST("v1/products/filter")
    suspend fun getFilteredProducts(
        @Body productFilter: ProductFilterDTO,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): List<ProductDTO>
}