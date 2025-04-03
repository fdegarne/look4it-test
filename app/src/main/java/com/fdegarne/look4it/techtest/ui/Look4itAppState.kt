package com.fdegarne.look4it.techtest.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.fdegarne.look4it.techtest.ui.home.ChallengeGraphRoute
import com.fdegarne.look4it.techtest.ui.home.FeedGraphRoute
import com.fdegarne.look4it.techtest.ui.home.TopLevelDestination
import com.fdegarne.look4it.techtest.ui.home.navigateToChallengeOfDay
import com.fdegarne.look4it.techtest.ui.home.navigateToFeed

@Composable
fun rememberLook4itAppState(
    navController: NavHostController = rememberNavController()
): Look4itAppState {
    return remember(
        navController
    ) {
        Look4itAppState(
            navController
        )
    }
}

class Look4itAppState(
    val navController: NavHostController,
) {
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    val currentDestination: NavDestination?
        @Composable get() {
            // Collect the currentBackStackEntryFlow as a state
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            // Fallback to previousDestination if currentEntry is null
            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.FEED -> navController.navigateToFeed(topLevelNavOptions)
            TopLevelDestination.CHALLENGE_OF_DAY -> navController.navigateToChallengeOfDay(topLevelNavOptions)
        }
    }
}