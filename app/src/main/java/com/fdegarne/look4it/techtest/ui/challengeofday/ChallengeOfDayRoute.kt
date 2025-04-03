package com.fdegarne.look4it.techtest.ui.challengeofday

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fdegarne.look4it.techtest.R
import com.fdegarne.look4it.techtest.core.data.model.ChallengeOfDay
import com.fdegarne.look4it.techtest.core.ui.EmptyScreen
import java.time.LocalDate

@Composable
fun ChallengeOfDayRoute(
    viewModel: ChallengeOfDayViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.loadChallengeOfDay()
        viewModel.createChallengeOfDayIfNecessary(context.getString(R.string.look_for_it))
    }

    when(val state = uiState) {
        ChallengeOfDayUiState.Error -> {}
        ChallengeOfDayUiState.Loading -> {}
        is ChallengeOfDayUiState.Success -> {
            state.challengeOfDay?.let { challengeOfDay ->
                ChallengeOfDayScreen(challengeOfDay)
            } ?: run {
                EmptyScreen(text = stringResource(R.string.no_more_challenge_today))
            }
        }
    }
}

@Composable
fun ChallengeOfDayScreen(
    challengeOfDay: ChallengeOfDay
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 50.dp),
            text = challengeOfDay.description,
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Button(
            onClick = {}
        ) {
            Text(stringResource(R.string.take_picture))
        }
    }
}

@Preview
@Composable
fun ShowChallengeOfDayScreen() {
    ChallengeOfDayScreen(
        ChallengeOfDay(
            id = 0,
            date = LocalDate.now(),
            locationId = 0,
            description = "Look4... a cinema !",
            consumed = false
        )
    )
}