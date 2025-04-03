package com.fdegarne.look4it.techtest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.fdegarne.look4it.techtest.R
import com.fdegarne.look4it.techtest.ui.theme.Look4itTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Look4itTheme {
                val appState: Look4itAppState = rememberLook4itAppState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        Look4itBottomBar(
                            destinations = appState.topLevelDestinations,
                            onNavigateToDestination = appState::navigateToTopLevelDestination,
                        )
                    }
                ) { innerPadding ->
                    Look4itNavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        appState = appState
                    )
                }
            }
        }
    }
}