package com.fdegarne.look4it.techtest.ui.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fdegarne.look4it.techtest.ui.challengeofday.ChallengeOfDayScreen
import com.fdegarne.look4it.techtest.ui.feed.FeedScreen
import kotlinx.serialization.Serializable

@Serializable object FeedGraphRoute
@Serializable object ChallengeGraphRoute

fun NavController.navigateToFeed(navOptions: NavOptions? = null) {
    navigate(route = FeedGraphRoute, navOptions)
}

fun NavGraphBuilder.feedScreen(
    navController: NavController,
    onBackClick: () -> Unit,
) {
    composable<FeedGraphRoute> {
        FeedScreen()
    }
}

fun NavController.navigateToChallengeOfDay(navOptions: NavOptions? = null) {
    navigate(ChallengeGraphRoute, navOptions)
}

fun NavGraphBuilder.challengeOfDayScreen(
    navController: NavController,
    onBackClick: () -> Unit,
) {
    composable<ChallengeGraphRoute> {
        ChallengeOfDayScreen()
    }
}