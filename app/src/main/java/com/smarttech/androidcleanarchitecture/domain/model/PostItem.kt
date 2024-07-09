package com.smarttech.androidcleanarchitecture.domain.model

import com.smarttech.androidcleanarchitecture.data.local.entity.PostEntity

data class PostItem(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)

fun PostItem.toPostEntity(): PostEntity {
    return PostEntity(id, userId, title, body)
}