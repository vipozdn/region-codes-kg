package com.lemon.regioncodeskg.new_civil_numbers

sealed interface UiEvent {

}

data class ViewModelState(val region: String = "") {

    companion object {
        val INITIAL = ViewModelState()
    }
}

sealed interface ViewModelEvent {
    sealed interface Navigation : ViewModelEvent {
        object GoBack : Navigation
    }
}