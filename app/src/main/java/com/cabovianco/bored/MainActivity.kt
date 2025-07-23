package com.cabovianco.bored

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.cabovianco.bored.presentation.viewmodel.MainViewModel
import com.cabovianco.bored.ui.screen.MainScreen
import com.cabovianco.bored.ui.theme.BoredTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoredTheme {
                val mainViewModel: MainViewModel = hiltViewModel()
                val uiState by mainViewModel.uiState.collectAsState()
                MainScreen(
                    uiState = uiState,
                    onGenerateActivity = { mainViewModel.fetchRandomActivity() },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
