package com.wearperfect.android.app.network

import android.util.Log
import com.wearperfect.android.app.data.repository.PreferencesDataStoreRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val preferencesDataStoreRepository: PreferencesDataStoreRepository): Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        // Make the code blocking explicitly
        val token = runBlocking {
            preferencesDataStoreRepository.getAccessToken().first()
        }
        Log.i("AuthInterceptor", "Intercepting request and adding auth token: $token.")
        if(token != null && token.trim().isNotEmpty()){
            requestBuilder.addHeader("Authorization", "Bearer $token")
            Log.i("AuthInterceptor", "Added auth token: ${token}.")
        }
        Log.i("AuthInterceptor", "Proceeding the chain with the updated request.")
        return chain.proceed(requestBuilder.build())
    }
}