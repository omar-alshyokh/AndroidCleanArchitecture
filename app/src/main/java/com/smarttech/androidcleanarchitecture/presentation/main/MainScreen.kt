package com.smarttech.androidcleanarchitecture.presentation.MainScreen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.smarttech.androidcleanarchitecture.core.components.CustomAppBar
import com.smarttech.androidcleanarchitecture.core.components.CustomPullToRefresh
import com.smarttech.androidcleanarchitecture.domain.model.PostItem
import com.smarttech.androidcleanarchitecture.core.components.navigation.StarterScreens
import com.smarttech.androidcleanarchitecture.presentation.main.MainViewModel

@OptIn( ExperimentalMaterialApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel(), navController: NavController) {
    val state by viewModel.state.collectAsState()


    Scaffold(
        topBar = {
            CustomAppBar(
                title = "Posts",
                navController = navController
            )
        }
    ) { paddingValues ->

        CustomPullToRefresh(
            isLoading = state.isLoading,
            onRefresh = {
                viewModel.refreshPosts()
            } ,
        ){
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                items(state.posts) { post ->
                    PostItem(post) {
                        navController.navigate(StarterScreens.PostDetailsScreen.name + "/${post.id}")

                    }
                }
            }

            if (state.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
fun PostItem(post: PostItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            text = post.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = post.body,
            style = MaterialTheme.typography.bodyMedium
        )
        Divider(
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
//        Surface {
//            MainScreen()
//        }
    }
}
