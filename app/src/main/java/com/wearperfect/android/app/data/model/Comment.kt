package com.wearperfect.android.app.data.model

data class Comment(
    val active: Boolean,
    val commentedBy: CommentedBy,
    val commentedOn: Long,
    val description: String,
    val id: Int,
    val lastUpdatedOn: Any,
    val postId: Int
)