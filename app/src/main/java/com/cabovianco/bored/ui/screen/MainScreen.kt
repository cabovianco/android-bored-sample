package com.cabovianco.bored.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cabovianco.bored.R
import com.cabovianco.bored.domain.model.Activity
import com.cabovianco.bored.presentation.state.MainUiState

@Composable
fun MainScreen(
    uiState: MainUiState,
    onGenerateActivity: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier) {
        val contentModifier = Modifier
            .fillMaxSize()
            .padding(it)

        when (uiState) {
            is MainUiState.Success -> OnSuccess(
                activity = uiState.activity,
                onGenerateActivity = onGenerateActivity,
                modifier = contentModifier
            )

            MainUiState.Error -> OnError(
                modifier = contentModifier
            )

            MainUiState.Loading -> OnLoading(
                modifier = contentModifier
            )
        }
    }
}

@Composable
private fun OnSuccess(
    activity: Activity,
    onGenerateActivity: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = activity.activity,
            modifier = Modifier.fillMaxWidth(0.75f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )

        TextButton(onClick = { onGenerateActivity() }) {
            Text(text = stringResource(R.string.generate_activity_button))
        }
    }
}

@Composable
private fun OnError(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.error),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
    }
}

@Composable
private fun OnLoading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
