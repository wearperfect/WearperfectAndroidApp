package com.wearperfect.android.app.data.service

import com.wearperfect.android.app.data.model.AccessToken
import com.wearperfect.android.app.data.model.UserCredential
import com.wearperfect.android.app.data.model.UserRegistrationData
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface AccountService {

    @POST("v1/login")
    suspend fun authenticateUser(@Body userCredential: UserCredential): AccessToken

    @POST("v1/signup")
    suspend fun registerUser(@Body userRegistrationData: UserRegistrationData): AccessToken

    @POST("v1/signout")
    suspend fun logoutUser(): Boolean

}