package com.lemon.regioncodeskg.new_civil_numbers

sealed interface UiEvent {
    data class DefineNum(val newCivilIds: List<String>) : UiEvent
}

data class ViewModelState(val keyboardIds: List<String> = listOf(),
                          val regionCodeResId: Int = -1,
                          val typedRegionCode: String = "") {

    companion object {
        val INITIAL = ViewModelState()
    }
}

sealed interface ViewModelEvent {
    sealed interface Navigation : ViewModelEvent {
        object GoBack : Navigation
    }
}