package com.smarttech.androidcleanarchitecture.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String,
    icon: ImageVector? = null,
    navController: NavController,
    onBackArrowClicked:() -> Unit = {},
    actions: @Composable() (RowScope.() -> Unit) = {}
) {

    Surface(
        modifier = Modifier.shadow(2.dp)
    ) {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (icon != null) {
                        Icon(imageVector = icon, contentDescription = "arrow back",
                            tint = Color.Red.copy(alpha = 0.7f),
                            modifier = Modifier.clickable { onBackArrowClicked.invoke() })
                    }
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = title,
                        color = Color.Red.copy(alpha = 0.7f),
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    )


                }


            },
            actions = actions,
            colors = TopAppBarDefaults.topAppBarColors(Color.White)
        )
    }

}