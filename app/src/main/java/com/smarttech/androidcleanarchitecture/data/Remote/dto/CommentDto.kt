package com.smarttech.androidcleanarchitecture.data.Remote.dto

import com.smarttech.androidcleanarchitecture.domain.model.CommentItem

data class CommentDto(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
) {
    fun toComment(): CommentItem {
        return CommentItem(postId, id, name, email, body)
    }
}
