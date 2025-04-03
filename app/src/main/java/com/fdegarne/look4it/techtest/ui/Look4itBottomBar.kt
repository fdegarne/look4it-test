package com.fdegarne.look4it.techtest.ui

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.fdegarne.look4it.techtest.core.ui.Look4itNavigationBarItem
import com.fdegarne.look4it.techtest.ui.home.TopLevelDestination

@Composable
fun Look4itBottomBar(
    modifier: Modifier = Modifier,
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        modifier = Modifier.heightIn(max = 200.dp),
        tonalElevation = 0.dp,
    ) {
        destinations.forEachIndexed { index, destination ->
            Look4itNavigationBarItem(
                modifier = modifier,
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = ImageVector.vectorResource(destination.unselectedIcon),
                        contentDescription = null
                    )
                },
                selectedIcon = {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = ImageVector.vectorResource(destination.selectedIcon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(destination.titleTextId))
                }
            )
        }
    }
}