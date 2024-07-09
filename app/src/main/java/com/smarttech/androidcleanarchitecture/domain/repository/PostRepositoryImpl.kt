package com.smarttech.androidcleanarchitecture.domain.repository

import com.smarttech.androidcleanarchitecture.data.Remote.PostApi
import com.smarttech.androidcleanarchitecture.module.main.data.local.entity.PostDao
import com.smarttech.androidcleanarchitecture.domain.model.CommentItem
import com.smarttech.androidcleanarchitecture.domain.model.PostItem
import com.smarttech.androidcleanarchitecture.domain.model.toPostEntity
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDao: PostDao,
    private val postApi: PostApi
) : PostRepository {
    override suspend fun getPosts(): List<PostItem> {
        return try {
            val postsFromApi = postApi.getPost().map { it.toPost() }
            postDao.insertPosts(postsFromApi.map { it.toPostEntity() })
            postsFromApi
        } catch (e: Exception) {
            postDao.getPosts().map { it.toPost() }
        }
    }

    override suspend fun getPost(id: Int): PostItem {
        return postApi.getPost(id).toPost()
    }

    override suspend fun getComments(postId: Int): List<CommentItem> {
        return postApi.getComments(postId).map { it.toComment() }
    }
}