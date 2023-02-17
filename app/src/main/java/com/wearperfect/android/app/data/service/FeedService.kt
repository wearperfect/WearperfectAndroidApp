package com.wearperfect.android.app.data.service

import com.wearperfect.android.app.data.model.FeedPost
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface FeedService {

    @GET("v1/feed")
    suspend fun getFeed(): List<FeedPost>

    @GET("v1/users/{userId}/feed")
    suspend fun getUserFeed(@Path("userId") userId: Long): List<FeedPost>
}