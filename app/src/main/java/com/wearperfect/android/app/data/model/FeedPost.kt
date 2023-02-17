package com.wearperfect.android.app.data.model

data class FeedPost(
    val active: Boolean,
    val comments: List<Comment>,
    val createdBy: Int,
    val createdByUserDetails: CreatedByUserDetails,
    val createdOn: Long,
    val description: String,
    val following: Any,
    val id: Int,
    val lastUpdatedBy: Any,
    val lastUpdatedByUserDetails: Any,
    val lastUpdatedOn: Any,
    val liked: Any,
    val postMediaList: List<PostMedia>,
    val saved: Any,
    val title: Any,
    val totalComments: Any,
    val totalLikes: Int
)