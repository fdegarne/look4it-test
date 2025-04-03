package com.fdegarne.look4it.techtest.ui.challengeofday

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import com.fdegarne.look4it.techtest.core.data.repositories.ChallengeOfDayRepository
import com.fdegarne.look4it.techtest.core.data.repositories.LocationRepository
import com.fdegarne.look4it.techtest.core.data.usecases.CreateChallengeOfDayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ChallengeOfDayViewModel @Inject constructor(
    locationRepository: LocationRepository,
    private val challengeOfDayRepository: ChallengeOfDayRepository,
    private val createChallengeOfDayUseCase: CreateChallengeOfDayUseCase
): ViewModel() {
    private val _challengeOfDay: MutableStateFlow<ChallengeOfDay?> = MutableStateFlow(null)
    val uiState = combine(
        locationRepository.getLocations(),
        _challengeOfDay
    ) { locations, challengeOfDay ->
        ChallengeOfDayUiState.Success(
            locations = locations,
            challengeOfDay = challengeOfDay
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = ChallengeOfDayUiState.Loading
    )

    fun loadChallengeOfDay() {
        viewModelScope.launch {
            challengeOfDayRepository.getChallengeOfDay(LocalDate.now(), false).collectLatest { challengeOfDay ->
                _challengeOfDay.update { challengeOfDay }
            }
        }
    }

    fun createChallengeOfDayIfNecessary(baseText: String) {
        viewModelScope.launch {
            createChallengeOfDayUseCase(baseText)
            loadChallengeOfDay()
        }
    }
}