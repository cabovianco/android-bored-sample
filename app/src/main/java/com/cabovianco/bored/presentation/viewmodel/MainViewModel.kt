package com.cabovianco.bored.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cabovianco.bored.domain.usecase.GetRandomActivityUseCase
import com.cabovianco.bored.presentation.state.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomActivityUseCase: GetRandomActivityUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState.Loading)
    val uiState get() = _uiState.asStateFlow()

    init {
        fetchRandomActivity()
    }

    fun fetchRandomActivity() {
        viewModelScope.launch {
            val response = getRandomActivityUseCase()
            if (response.isFailure) {
                _uiState.value = MainUiState.Error
            } else {
                _uiState.value = MainUiState.Success(activity = response.getOrNull()!!)
            }
        }
    }
}
