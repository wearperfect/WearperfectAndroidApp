package com.wearperfect.android.app.data.repository

import android.util.Log
import com.wearperfect.android.app.data.model.FeedPost
import com.wearperfect.android.app.data.service.FeedService
import javax.inject.Inject

class FeedRepository @Inject constructor(private val feedService: FeedService){

    suspend fun getFeed(): List<FeedPost>{
        try {
            return feedService.getFeed();
        }catch (e: Exception){
            Log.i("FeedRepository", "getFeed: Exception Occurred. ${e.message}")
        }
        return emptyList();
    }

    suspend fun getUserFeed(userId: Long): List<FeedPost>{
        return feedService.getUserFeed(userId = userId);
    }
}