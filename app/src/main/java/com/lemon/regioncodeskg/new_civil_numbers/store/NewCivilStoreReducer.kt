package com.lemon.regioncodeskg.new_civil_numbers.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.lemon.regioncodeskg.new_civil_numbers.keysToResultResId
import com.lemon.regioncodeskg.ui.keyboards.KeyboardItemData
import com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard.NewCivilKeyboardBuilder

object NewCivilReducerImpl : Reducer<NewCivilStore.State, Message> {
    override fun NewCivilStore.State.reduce(msg: Message): NewCivilStore.State =
        when (msg) {
            is Message.DefineNumResult -> {
                val defineNumOutputState = this as NewCivilStore.State.DefineNumOutput

                val storedIds =
                    if (defineNumOutputState.keyboardIds.size > 2)
                        defineNumOutputState.keyboardIds
                    else defineNumOutputState.keyboardIds + msg.newCivilIds

                val strResId = keysToResultResId(storedIds)
                val typedRegionCode = storedIds.keyboardIdsToRegionCode()

                defineNumOutputState.copy(outputStrResId = strResId,
                    keyboardIds = storedIds, typedRegionCode = typedRegionCode)
            }
        }
}

private fun List<String>.keyboardIdsToRegionCode(): String {
    val ids = this.take(2) // new civil car plate numbers can contain only 2 digits
    return getKeyboardItemText(ids[0]) + getKeyboardItemText(ids[1])
}

private fun getKeyboardItemText(id: String): String {
    return NewCivilKeyboardBuilder
        .getKeyboardItemData(id)
        .keyboardItemData.text
}