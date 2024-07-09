package com.smarttech.androidcleanarchitecture.domain.usecase

import com.smarttech.androidcleanarchitecture.domain.model.PostItem
import com.smarttech.androidcleanarchitecture.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend fun execute(): List<PostItem> = postRepository.getPosts()
}