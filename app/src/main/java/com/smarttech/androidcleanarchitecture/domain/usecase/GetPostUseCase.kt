package com.smarttech.androidcleanarchitecture.domain.usecase

import com.smarttech.androidcleanarchitecture.domain.model.PostItem
import com.smarttech.androidcleanarchitecture.domain.repository.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend fun execute(id: Int): PostItem = postRepository.getPost(id)
}