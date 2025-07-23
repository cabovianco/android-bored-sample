package com.cabovianco.bored.presentation.state

import com.cabovianco.bored.domain.model.Activity

sealed interface MainUiState {
    data class Success(val activity: Activity) : MainUiState
    data object Error : MainUiState
    data object Loading : MainUiState
}
