package com.lemon.regioncodeskg.new_civil_numbers.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.lemon.regioncodeskg.new_civil_numbers.keysToResultResId

object NewCivilReducerImpl : Reducer<NewCivilStore.State, Message> {
    override fun NewCivilStore.State.reduce(msg: Message): NewCivilStore.State =
        when (msg) {
            is Message.DefineNumResult -> {
                val strResId = keysToResultResId(msg.newCivilIds)
                (this as NewCivilStore.State.DefineNumOutput).copy(outputStrResId = strResId)
            }
        }
}