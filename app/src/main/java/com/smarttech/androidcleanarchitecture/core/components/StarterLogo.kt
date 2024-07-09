package com.smarttech.androidcleanarchitecture.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StarterLogo(modifier: Modifier = Modifier) {
    Text(
        text = "A. Starter",
        modifier = modifier.padding(16.dp),
        style = MaterialTheme.typography.displayLarge,
        color = Color.Red.copy(alpha = 0.5f)
    )
}