package com.wearperfect.android.app.data.service

import com.wearperfect.android.app.data.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface UserService {

    @GET("v1/users/{userId}")
    suspend fun getUserDetailsByUserId(@Path("userId") userId: Long): User

    @GET("v1/users/{username}")
    suspend fun getUserDetailsByUsername(@Path("username") username: String): User

    @GET("v1/me")
    suspend fun getLoggedInUserDetails(): User

    // Don't combine suspend with Call<T>
    @GET("v1/me")
    suspend fun getLoggedInUserInfo(): Call<User>
}