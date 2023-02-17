package com.wearperfect.android.app.data.model

data class PostMedia(
    val active: Boolean,
    val aspectRatio: Double,
    val contentType: String,
    val createdOn: Long,
    val height: Int,
    val id: Int,
    val lastUpdatedOn: Long,
    val postId: Int,
    val sequenceId: Int,
    val sourceLink: String,
    val userTags: List<Any>,
    val width: Int
)