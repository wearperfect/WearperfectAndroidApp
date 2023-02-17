package com.wearperfect.android.app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearperfect.android.app.constant.network.RequestState
import com.wearperfect.android.app.data.model.AccessToken
import com.wearperfect.android.app.data.model.UserCredential
import com.wearperfect.android.app.data.model.UserRegistrationData
import com.wearperfect.android.app.data.repository.AccountRepository
import com.wearperfect.android.app.data.repository.PreferencesDataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
    private val preferencesDataStoreRepository: PreferencesDataStoreRepository
) : ViewModel() {

    private val _logInStateFlow = MutableStateFlow<RequestState<Boolean>>(RequestState.Idle)
    val logInStateFlow: StateFlow<RequestState<Boolean>> = _logInStateFlow

    private val _signUpStateFlow = MutableStateFlow<RequestState<AccessToken>>(RequestState.Idle)
    val signUpStateFlow: StateFlow<RequestState<AccessToken>> = _signUpStateFlow

    fun authenticateUser(userCredential: UserCredential) {
        _logInStateFlow.value = RequestState.Loading
        try {
            viewModelScope.launch {
                val data = accountRepository.authenticateUser(userCredential = userCredential)
                if (data != null && data.accessToken.toString().trim().isNotEmpty()) {
                    insertAccessToken(data.accessToken)
                    _logInStateFlow.value = RequestState.Success(data = true)
                    Log.i("AccountViewModel", "authenticateUser: Login Successful.")
                } else {
                    _logInStateFlow.value = RequestState.Error(Exception("Authentication Failed."))
                    Log.i("AccountViewModel", "authenticateUser: Login Failed.")
                }
            }
        } catch (e: Exception) {
            _logInStateFlow.value = RequestState.Error(e)
        }
    }

    fun registerUser(userRegistrationData: UserRegistrationData) {
        _signUpStateFlow.value = RequestState.Loading
        try {
            viewModelScope.launch {
                val data = accountRepository.registerUser(userRegistrationData)
                if (data != null && data.accessToken.toString().trim().isNotEmpty()) {
                    insertAccessToken(data.accessToken)
                    _signUpStateFlow.value = RequestState.Success(data = data)
                    _logInStateFlow.value = RequestState.Success(data = true)
                    Log.i("AccountViewModel", "registerUser: Registration Successful.")
                } else {
                    _signUpStateFlow.value = RequestState.Error(Exception("Registration Failed."))
                    Log.i("AccountViewModel", "registerUser: Registration Failed.")
                }
            }
        } catch (e: Exception) {
            _signUpStateFlow.value = RequestState.Error(e)
        }
    }

    fun logoutUser() {
        _logInStateFlow.value = RequestState.Loading
        try {
            viewModelScope.launch {
                val data: Boolean = accountRepository.logoutUser()
                if (data) {
                    deleteAccessToken()
                    _logInStateFlow.value = RequestState.Idle
                    _signUpStateFlow.value = RequestState.Idle
                    Log.i("AccountViewModel", "registerUser: Logout Successful.")
                } else {
                    _logInStateFlow.value = RequestState.Error(Exception("Logout Failed."))
                    Log.i("AccountViewModel", "registerUser: Logout Failed.")
                }
            }
        } catch (e: Exception) {
            _logInStateFlow.value = RequestState.Error(e)
        }
    }

    fun verifyLogin() {
        _logInStateFlow.value = RequestState.Loading
        try {
            viewModelScope.launch {
                preferencesDataStoreRepository.getAccessToken().collect { accessToken ->
                    if(accessToken?.trim()?.isNotEmpty() == true)
                        _logInStateFlow.value = RequestState.Success(data = true)
                    else
                        _logInStateFlow.value = RequestState.Success(data = false)
                }
            }
        } catch (e: Exception) {
            _logInStateFlow.value = RequestState.Error(e)
        }
    }

    private fun insertAccessToken(accessToken: String) {
        viewModelScope.launch {
            preferencesDataStoreRepository.insertAccessToken(accessToken)
        }
    }

    private fun deleteAccessToken() {
        viewModelScope.launch {
            preferencesDataStoreRepository.deleteAccessToken()
        }
    }
}