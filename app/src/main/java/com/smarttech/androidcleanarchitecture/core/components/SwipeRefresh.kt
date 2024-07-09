//package com.smarttech.androidcleanarchitecture.components
//
//import android.view.ViewGroup
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.ComposeView
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.core.view.ViewCompat
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
//
//@Composable
//fun SwipeRefresh(
//    isRefreshing: Boolean,
//    onRefresh: () -> Unit,
//    modifier: Modifier = Modifier,
//    content: @Composable () -> Unit
//) {
//    val context = LocalContext.current
//    val density = LocalDensity.current
//
//    AndroidView(
//        factory = {
//            SwipeRefreshLayout(context).apply {
//                setOnRefreshListener { onRefresh() }
//                setColorSchemeColors(
//                    ViewCompat.MEASURED_STATE_MASK,
//                    0xFFFF0000.toInt(),
//                    0xFF00FF00.toInt(),
//                    0xFF0000FF.toInt()
//                )
//                addView(
//                    ComposeView(context).apply {
//                        setContent {
//                            content()
//                        }
//                    },
//                    ViewGroup.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT
//                    )
//                )
//            }
//        },
//        update = { view ->
//            view.isRefreshing = isRefreshing
//        },
//        modifier = modifier
//    )
//}