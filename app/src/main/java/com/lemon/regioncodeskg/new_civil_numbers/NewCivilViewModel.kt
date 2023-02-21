package com.lemon.regioncodeskg.new_civil_numbers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class NewCivilViewModel() : ViewModel() {

    val states: Flow<ViewModelState>
        get() = _states
    val uiEvents: Flow<UiEvent>
        get() = _uiEvents

    private val _states = MutableSharedFlow<ViewModelState>(replay = 1)
    private val _events = MutableSharedFlow<ViewModelEvent>()
    private val _uiEvents = MutableSharedFlow<UiEvent>()

    fun onState(state: ViewModelState) = viewModelScope.launch {
        _states.emit(state)
    }

    fun onEvent(event: UiEvent) = viewModelScope.launch {
        _uiEvents.emit(event)
    }

    internal fun onViewModelEvent(event: ViewModelEvent) = viewModelScope.launch {
        _events.emit(event)
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                NewCivilViewModel()
            }
        }
    }

}