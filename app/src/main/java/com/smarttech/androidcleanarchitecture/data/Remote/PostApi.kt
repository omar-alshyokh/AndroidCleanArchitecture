package com.smarttech.androidcleanarchitecture.data.Remote

import com.smarttech.androidcleanarchitecture.data.Remote.dto.CommentDto
import com.smarttech.androidcleanarchitecture.data.Remote.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("/posts")
    suspend fun getPost(): ArrayList<PostDto>


    @GET("/posts/{id}")
    suspend fun getPost(@Path("id") id: Int): PostDto

    @GET("/posts/{id}/comments")
    suspend fun getComments(@Path("id") postId: Int): List<CommentDto>
}