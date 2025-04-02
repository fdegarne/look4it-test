package com.fdegarne.look4it.techtest.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.fdegarne.look4it.techtest.R

/**
 * Enum class that define tabs destination for the main NavHost
 */
enum class TopLevelDestination(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val titleTextId: Int,
) {
    FEED(
        selectedIcon = R.drawable.ic_feed_selected,
        unselectedIcon = R.drawable.ic_feed_unselected,
        titleTextId = R.string.tab_title_feed
    ),
    CHALLENGE_OF_DAY(
        selectedIcon = R.drawable.ic_challenge_selected,
        unselectedIcon = R.drawable.ic_challenge_unselected,
        titleTextId = R.string.tab_title_challenge_day
    )
}