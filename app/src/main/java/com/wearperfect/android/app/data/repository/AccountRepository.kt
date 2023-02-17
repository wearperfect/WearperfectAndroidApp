package com.wearperfect.android.app.data.repository

import com.wearperfect.android.app.data.dao.AccountDAO
import com.wearperfect.android.app.data.model.AccessToken
import com.wearperfect.android.app.data.model.UserCredential
import com.wearperfect.android.app.data.model.UserRegistrationData
import com.wearperfect.android.app.data.service.AccountService
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountDAO: AccountDAO,
    private val accountService: AccountService
) {

    suspend fun authenticateUser(userCredential: UserCredential): AccessToken {
        return accountService.authenticateUser(userCredential)
    }

    suspend fun registerUser(userRegistrationData: UserRegistrationData): AccessToken {
        return accountService.registerUser(userRegistrationData)
    }

    suspend fun logoutUser(): Boolean {
        return accountService.logoutUser()
    }
}