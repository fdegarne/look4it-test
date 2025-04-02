package com.fdegarne.look4it.techtest.ui.feed

import androidx.lifecycle.ViewModel
import com.fdegarne.look4it.techtest.core.data.repositories.ChallengesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val challengesRepository: ChallengesRepository
): ViewModel() {
}