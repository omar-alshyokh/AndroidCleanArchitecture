package com.smarttech.androidcleanarchitecture.presentation.Splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.smarttech.androidcleanarchitecture.core.components.StarterLogo
import com.smarttech.androidcleanarchitecture.core.components.navigation.StarterScreens
import kotlinx.coroutines.delay


@Composable
fun StarterSplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(durationMillis = 1000, easing = {
                OvershootInterpolator(8f)
                    .getInterpolation(it)
            })
        )

        delay(2000L)
        navController.navigate(StarterScreens.MainScreen.name){
            popUpTo(StarterScreens.SplashScreen.name) { inclusive = true }
        }
    }

    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(330.dp)
            .scale(scale.value),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(
            color = Color.LightGray,
            width = 2.dp
        )
    ) {

        Column(
            modifier = Modifier
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            StarterLogo()
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "\"Clean Architecture\"",
                style = MaterialTheme.typography.labelLarge,
                color = Color.LightGray
            )

        }

    }
}

