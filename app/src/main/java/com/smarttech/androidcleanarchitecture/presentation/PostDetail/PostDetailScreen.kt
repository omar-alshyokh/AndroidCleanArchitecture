package com.smarttech.androidcleanarchitecture.presentation.PostDetail


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.smarttech.androidcleanarchitecture.core.components.CustomAppBar
import com.smarttech.androidcleanarchitecture.domain.model.CommentItem

@Composable
fun PostDetailScreen(postId: Int, viewModel: PostDetailViewModel = hiltViewModel(),navController: NavController) {
    val post by viewModel.post.collectAsState()
    val comments by viewModel.comments.collectAsState()

    Scaffold(
        topBar = {
            CustomAppBar(
                title = "Details",
                icon = Icons.Default.ArrowBack,
                navController,
                onBackArrowClicked = {
                    navController.popBackStack()
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            post?.let {
                Text(text = it.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.body, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Comments", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
            }

            LazyColumn {
                items(comments) { comment ->
                    CommentItem(comment)
                }
            }
        }
    }

    LaunchedEffect(postId) {
        viewModel.fetchPostDetails(postId)
    }
}

@Composable
fun CommentItem(comment: CommentItem) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = comment.name, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = comment.body, style = MaterialTheme.typography.bodySmall)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}
