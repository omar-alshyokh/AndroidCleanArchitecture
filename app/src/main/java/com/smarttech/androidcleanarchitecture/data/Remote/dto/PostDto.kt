package com.smarttech.androidcleanarchitecture.data.Remote.dto

import com.smarttech.androidcleanarchitecture.domain.model.PostItem

data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) {
    fun toPost(): PostItem {
        return PostItem(userId, id, title, body)
    }
}
