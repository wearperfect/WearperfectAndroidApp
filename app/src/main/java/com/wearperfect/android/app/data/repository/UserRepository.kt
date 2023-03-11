package com.wearperfect.android.app.data.repository

import android.util.Log
import com.wearperfect.android.app.data.model.User
import com.wearperfect.android.app.data.service.UserService
import com.wearperfect.android.app.util.wrapper.DataOrException
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val userService: UserService,
    private val preferencesDataStoreRepository: PreferencesDataStoreRepository
): Exception() {

    suspend fun getLoggedInUserDetails(): User{
        try{
            return userService.getLoggedInUserDetails()
        } catch (e: Exception){
            Log.i("UserRepository", "getLoggedInUserDetails: ${e.message}")
        }
        return userService.getLoggedInUserDetails()
    }

    suspend fun getLoggedInUserInfo(): DataOrException<User, Boolean, Exception>{

        var userInfoData: DataOrException<User, Boolean, Exception> = DataOrException(null, true, null)

        try {
            val call: Call<User> = userService.getLoggedInUserInfo()


        call.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                Log.i("getLoggedInUserInfo", "OnSuccess:::${response?.body()}")
                userInfoData.data = response?.body()
            }

            override fun onFailure(call: Call<User?>?, t: Throwable?) {
                if (t is IOException) {
                    Log.i("getLoggedInUserInfo", "onFailure IOException : ${t.message}")
                    userInfoData.exception = t
                } else if (t is IllegalStateException) {
                    Log.i("getLoggedInUserInfo", "onFailure IllegalStateException : ${t.message}")
                    userInfoData.exception = t
                } else {
                    // Handle other failures
                    Log.i("getLoggedInUserInfo", "Handle other failures")
                }
            }
        })
        } catch (e: HttpException){
            val errorResponse = e.response()?.errorBody()?.string()
            Log.e("getLoggedInUserInfo", "Handle HTTP Exception->${e.message}")
            Log.e("getLoggedInUserInfo", "HTTP Exception->${errorResponse}")
            if(e.code() == 401 || e.code() == 403){
                preferencesDataStoreRepository.deleteAccessToken()
                Log.i("getLoggedInUserInfo", "Deleted Access Token: ")
            }
        } catch (e: Exception){
            Log.e("getLoggedInUserInfo", "Handle other Exceptions:::${e.message}")
        }
        return userInfoData;
    }
}