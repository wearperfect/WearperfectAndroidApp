package com.wearperfect.android.app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.data.model.User
import com.wearperfect.android.app.data.repository.UserRepository
import com.wearperfect.android.app.data.service.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    private val _loggedInUserDetails = MutableStateFlow<RequestState<User>>(RequestState.Idle)
    val loggedInUserDetails: StateFlow<RequestState<User>> = _loggedInUserDetails

    fun getLoggedInUserDetails(){
        _loggedInUserDetails.value = RequestState.Loading
        try{
            viewModelScope.launch {
                val response = userRepository.getLoggedInUserInfo().data
                if(response != null && response.toString().isNotEmpty()){
                    _loggedInUserDetails.value = RequestState.Success(response)
                } else {
                    _loggedInUserDetails.value = RequestState.Error(Exception("Invalid Response"))
                }
            }
        } catch (e: Exception){
            Log.e("UserDetailsViewModel", "getLoggedInUserDetails: ${e.message}")
            _loggedInUserDetails.value = RequestState.Error(e)
        }
    }
}