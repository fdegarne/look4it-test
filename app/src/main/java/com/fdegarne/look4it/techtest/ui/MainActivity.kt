package com.fdegarne.look4it.techtest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.fdegarne.look4it.techtest.ui.theme.Look4itTheme

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
                            currentDestination = appState.currentDestination,
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