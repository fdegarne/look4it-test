package com.fdegarne.look4it.techtest.ui.challengeofday

import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import com.fdegarne.look4it.techtest.core.data.model.Location

sealed interface ChallengeOfDayUiState {
    data object Loading : ChallengeOfDayUiState
    data class Success(
        val locations: List<Location>,
        val challengeOfDay: ChallengeOfDay?
    ) : ChallengeOfDayUiState
    data object Error : ChallengeOfDayUiState
}