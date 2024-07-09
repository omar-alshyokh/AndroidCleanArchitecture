package com.smarttech.androidcleanarchitecture.presentation.PostDetail


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarttech.androidcleanarchitecture.domain.model.CommentItem
import com.smarttech.androidcleanarchitecture.domain.model.PostItem
import com.smarttech.androidcleanarchitecture.domain.usecase.GetCommentsUseCase
import com.smarttech.androidcleanarchitecture.domain.usecase.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {

    private val _post = MutableStateFlow<PostItem?>(null)
    val post: StateFlow<PostItem?> = _post

    private val _comments = MutableStateFlow<List<CommentItem>>(emptyList())
    val comments: StateFlow<List<CommentItem>> = _comments

    fun fetchPostDetails(postId: Int) {
        viewModelScope.launch {
            val post = getPostUseCase.execute(postId)
            _post.value = post
            val comments = getCommentsUseCase.execute(postId)
            _comments.value = comments
        }
    }
}
