package com.fdegarne.look4it.techtest.ui.challengeofday

import androidx.lifecycle.ViewModel
import com.fdegarne.look4it.techtest.core.data.repositories.ChallengeOfDayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChallengeOfDayViewModel @Inject constructor(
    private val challengeOfDayRepository: ChallengeOfDayRepository
): ViewModel() {
}