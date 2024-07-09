package com.smarttech.androidcleanarchitecture.domain.usecase

import com.smarttech.androidcleanarchitecture.domain.model.CommentItem
import com.smarttech.androidcleanarchitecture.domain.repository.PostRepository
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend fun execute(postId: Int): List<CommentItem> = postRepository.getComments(postId)
}