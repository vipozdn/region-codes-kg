package com.lemon.regioncodeskg.new_civil_numbers

import com.lemon.regioncodeskg.new_civil_numbers.store.NewCivilStore

internal val stateToModel: NewCivilStore.State.() -> ViewModelState = {
    when (this) {
        is NewCivilStore.State.DefineNumOutput -> {
            ViewModelState(keyboardIds = this.keyboardIds,
                regionCodeResId = this.outputStrResId,
                typedRegionCode = this.typedRegionCode)
        }
    }
}

internal val eventToIntent: UiEvent.() -> NewCivilStore.Intent = {
    when (this) {
        is UiEvent.DefineNum -> NewCivilStore.Intent.DefineNum(this.newCivilIds)
    }
}