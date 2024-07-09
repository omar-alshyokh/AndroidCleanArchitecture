package com.smarttech.androidcleanarchitecture.core.components.navigation

enum class StarterScreens {
    SplashScreen,
    MainScreen,
    PostDetailsScreen;

    companion object {
        fun fromRoute(route: String?): StarterScreens = when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            MainScreen.name -> MainScreen
            PostDetailsScreen.name -> PostDetailsScreen
            null -> MainScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}