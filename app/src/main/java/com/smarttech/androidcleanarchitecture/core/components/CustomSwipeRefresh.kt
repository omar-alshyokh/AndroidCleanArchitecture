package com.smarttech.androidcleanarchitecture.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomPullToRefresh(
    isLoading: Boolean,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isLoading,
        onRefresh = onRefresh
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {
        content()

        CustomPullRefreshIndicator(
            isLoading = isLoading,
            pullRefreshState = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomPullRefreshIndicator(
    isLoading: Boolean,
    pullRefreshState: PullRefreshState,
    modifier: Modifier = Modifier
) {
    PullRefreshIndicator(
        refreshing = isLoading,
        state = pullRefreshState,
        modifier = modifier,
        backgroundColor = if (isLoading) Color.Red else Color.Green,
        contentColor = Color.White,

    )
}
