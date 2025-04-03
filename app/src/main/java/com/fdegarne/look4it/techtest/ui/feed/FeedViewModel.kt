package com.fdegarne.look4it.techtest.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fdegarne.look4it.techtest.core.data.repositories.ChallengesRepository
import com.fdegarne.look4it.techtest.core.data.repositories.LocationRepository
import com.fdegarne.look4it.techtest.ui.challengeofday.ChallengeOfDayUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    locationRepository: LocationRepository,
    challengesRepository: ChallengesRepository
): ViewModel() {
    val uiState = combine(
        locationRepository.getLocations(),
        challengesRepository.getChallenges()
    ) { locations, challenges ->
        FeedUiState.Success (
            locations = locations,
            challenges = challenges
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = ChallengeOfDayUiState.Loading
    )
}