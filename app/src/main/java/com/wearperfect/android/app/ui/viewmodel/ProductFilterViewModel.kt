package com.wearperfect.android.app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.data.dto.ProductDTO
import com.wearperfect.android.app.data.dto.ProductFilterDTO
import com.wearperfect.android.app.data.repository.PreferencesDataStoreRepository
import com.wearperfect.android.app.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductFilterViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val preferencesDataStoreRepository: PreferencesDataStoreRepository
): ViewModel() {
    private val _filteredProductsStateFlow = MutableStateFlow<RequestState<List<ProductDTO>>>(RequestState.Idle)
    val filteredProductsStateFlow: StateFlow<RequestState<List<ProductDTO>>> = _filteredProductsStateFlow

    fun getFilteredProducts(productFilter: ProductFilterDTO, page: Int, size: Int){
        _filteredProductsStateFlow.value = RequestState.Loading
        try {
            viewModelScope.launch {
                val data = productRepository.getFilteredProducts(productFilter, page, size)
                if(data != null && data.toString().trim().isNotEmpty()){
                    _filteredProductsStateFlow.value = RequestState.Success(data = data)
                    Log.i("FilteredProductsSize", "getFilteredProducts: ${data.size}")
                }
            }
        } catch (e: Exception){
            _filteredProductsStateFlow.value = RequestState.Error(e)
            Log.e("ProductFilterViewModel", "getFilteredProducts: ${e.message}" )
            deleteAccessToken()
        }
    }

    private fun deleteAccessToken() {
        viewModelScope.launch {
            preferencesDataStoreRepository.deleteAccessToken()
        }
    }
}