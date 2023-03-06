package com.lemon.regioncodeskg.new_civil_numbers

sealed interface UiEvent {
    data class DefineNum(val newCivilIds: List<String>) : UiEvent
}

data class ViewModelState(val regionCodeResId: Int = -1) {

    companion object {
        val INITIAL = ViewModelState()
    }
}

sealed interface ViewModelEvent {
    sealed interface Navigation : ViewModelEvent {
        object GoBack : Navigation
    }
}