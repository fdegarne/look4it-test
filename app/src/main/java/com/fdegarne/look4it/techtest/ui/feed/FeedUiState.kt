package com.fdegarne.look4it.techtest.ui.feed

import com.fdegarne.look4it.techtest.core.data.model.Challenge
import com.fdegarne.look4it.techtest.core.data.model.Location

sealed interface FeedUiState {
    data object Loading : FeedUiState
    data class Success(
        val locations: List<Location>,
        val challenges: List<Challenge>
    ) : FeedUiState
    data object Error : FeedUiState
}