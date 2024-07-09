package com.smarttech.androidcleanarchitecture.core.components.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.smarttech.androidcleanarchitecture.presentation.MainScreen.MainScreen
import com.smarttech.androidcleanarchitecture.presentation.PostDetail.PostDetailScreen
import com.smarttech.androidcleanarchitecture.presentation.PostDetail.PostDetailViewModel
import com.smarttech.androidcleanarchitecture.presentation.Splash.StarterSplashScreen
import com.smarttech.androidcleanarchitecture.presentation.main.MainViewModel


@Composable
fun StarterNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = StarterScreens.SplashScreen.name ){

        composable(StarterScreens.SplashScreen.name) {
            StarterSplashScreen(navController = navController)
        }
        composable(StarterScreens.MainScreen.name) {
            val homeViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, viewModel = homeViewModel)
        }

        val detailName = StarterScreens.PostDetailsScreen.name
        composable("$detailName/{postId}", arguments = listOf(navArgument("postId"){
            type = NavType.IntType
        })) { backStackEntry ->
            backStackEntry.arguments?.getInt("postId").let {
                val postDetailViewModel = hiltViewModel<PostDetailViewModel>()
                PostDetailScreen(navController = navController, postId = it!!, viewModel = postDetailViewModel)
            }
        }

    }

}