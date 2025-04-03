package com.fdegarne.look4it.techtest.ui.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fdegarne.look4it.techtest.R
import com.fdegarne.look4it.techtest.core.data.model.Challenge
import com.fdegarne.look4it.techtest.core.data.model.Location
import com.fdegarne.look4it.techtest.core.ui.EmptyScreen

@Composable
fun FeedRoute(
    viewModel: FeedViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when(val state = uiState) {
        FeedUiState.Error -> {}
        FeedUiState.Loading -> {}
        is FeedUiState.Success -> {
            if (state.challenges.isNotEmpty()) {
                FeedScreen(state.challenges, state.locations)
            } else {
                EmptyScreen(stringResource(R.string.no_challenge_in_feed))
            }
        }
    }
}

@Composable
fun FeedScreen(
    challenges: List<Challenge>,
    locations: List<Location>
) {
    LazyColumn (
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(
            count = challenges.size,
            key = { challenges[it].id },
        ) { index ->
            val challenge = challenges[index]
            val location = locations.firstOrNull { it.id == challenge.locationId }
            FeedItem(challenge, location)
        }
    }
}