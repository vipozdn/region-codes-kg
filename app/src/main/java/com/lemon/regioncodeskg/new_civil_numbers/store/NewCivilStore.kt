package com.lemon.regioncodeskg.new_civil_numbers.store

import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.lemon.regioncodeskg.ui.keyboards.new_civil_keyboard.NewCivilKeyboardItems

interface NewCivilStore : Store<NewCivilStore.Intent, NewCivilStore.State, NewCivilStore.News> {

    sealed interface Intent {
        data class DefineNum(val newCivilIds: List<String>) : Intent
    }

    sealed interface State {
        data class DefineNumOutput(val keyboardIds: List<String>,
                                   val outputStrResId: Int,
                                   val typedRegionCode: String) : State
    }

    sealed interface News {
        object GoBackRequested : News
    }

}

sealed interface Message {
    data class DefineNumResult(val newCivilIds: List<String>) : Message
}

sealed interface Action {
    data class HandleIntent(val intent: NewCivilStore.Intent) : Action
    data class DefineNumInput(val newCivilIds: List<String>) : Action
    companion object {
        fun fromIntent(intent : NewCivilStore.Intent): Action {
            return HandleIntent(intent)
        }
    }
}

object NewCivilStoreFactory {
    fun create(storeFactory: StoreFactory) : NewCivilStore {

        val initialState = createInitialState()
        val bootstrapper = SimpleBootstrapper(
            Action.DefineNumInput(
                listOf(
                    NewCivilKeyboardItems.NEW_CIVIL_0,
                    NewCivilKeyboardItems.NEW_CIVIL_1
                )
            )
        )
        val reducer = NewCivilReducerImpl
        val impl = storeFactory.create(
            name = "NewCivilStore",
            initialState = initialState,
            executorFactory = ::NewCivilStoreExecutor,
            reducer = reducer,
            bootstrapper = bootstrapper)

        return object : NewCivilStore, Store<NewCivilStore.Intent,
                NewCivilStore.State,
                NewCivilStore.News> by impl {}
    }
}

private fun createInitialState(): NewCivilStore.State.DefineNumOutput {
    return NewCivilStore.State.DefineNumOutput(listOf(), -1, "")
}