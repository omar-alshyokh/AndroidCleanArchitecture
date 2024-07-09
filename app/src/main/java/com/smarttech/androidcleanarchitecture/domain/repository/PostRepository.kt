package com.smarttech.androidcleanarchitecture.domain.repository

import com.smarttech.androidcleanarchitecture.domain.model.CommentItem
import com.smarttech.androidcleanarchitecture.domain.model.PostItem

interface PostRepository {
    suspend fun getPosts(): List<PostItem>
    suspend fun getPost(id: Int): PostItem
    suspend fun getComments(postId: Int): List<CommentItem>

}