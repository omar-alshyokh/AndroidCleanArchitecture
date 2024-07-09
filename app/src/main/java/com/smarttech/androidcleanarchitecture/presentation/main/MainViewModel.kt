package com.smarttech.androidcleanarchitecture.presentation.main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smarttech.androidcleanarchitecture.domain.model.PostItem
import com.smarttech.androidcleanarchitecture.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
data class PostState(val posts: List<PostItem> = emptyList(), val isLoading: Boolean = false)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {


    private val _state = MutableStateFlow(PostState())
    val state: StateFlow<PostState> = _state


    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            _state.value = PostState(isLoading = true)
            try {
                val posts = getPostsUseCase.execute()
                _state.value = PostState(posts = posts, isLoading = false)
            } catch (e: Exception) {
                // Handle exception
                _state.value = PostState(isLoading = false)
            }
        }
    }

    fun refreshPosts() {
        loadPosts()
    }
}
