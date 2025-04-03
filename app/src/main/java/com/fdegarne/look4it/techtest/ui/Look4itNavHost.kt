package com.fdegarne.look4it.techtest.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.fdegarne.look4it.techtest.ui.home.FeedGraphRoute
import com.fdegarne.look4it.techtest.ui.home.challengeOfDayScreen
import com.fdegarne.look4it.techtest.ui.home.feedScreen

@Composable
fun Look4itNavHost(
    appState: Look4itAppState,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = FeedGraphRoute,
        modifier = modifier,
    ) {
        feedScreen(
            navController = navController,
            onBackClick = { }
        )

        challengeOfDayScreen(
            navController = navController,
            onBackClick = { }
        )
    }
}