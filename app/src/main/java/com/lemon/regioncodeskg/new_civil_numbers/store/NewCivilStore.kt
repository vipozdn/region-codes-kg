package com.lemon.regioncodeskg.new_civil_numbers.store

import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory

interface NewCivilStore : Store<NewCivilStore.Intent, NewCivilStore.State, NewCivilStore.News> {

    sealed interface Intent {
        data class DefineNum(val newCivilIds: List<String>) : Intent
    }

    sealed interface State {
        data class DefineNumOutput(val output: String) : State
    }

    sealed interface News {
        object GoBackRequested : News
    }

}

sealed interface Effect {
    data class DefineNumResult(val output: String) : Effect
}

sealed interface Action {
    data class HandleIntent(val intent: NewCivilStore.Intent) : Action
    object DefineNumOutput : Action
    companion object {
        fun fromIntent(intent : NewCivilStore.Intent): Action {
            return HandleIntent(intent)
        }
    }
}

object NewCivilStoreFactory {
    fun create(storeFactory: StoreFactory) : NewCivilStore {

        val initialState = createInitialState()
        val bootstrapper = SimpleBootstrapper(Action.DefineNumOutput)
        val reducer = createReducer(initialState)
        val impl = storeFactory.create(
            name = "NewCivilStore",
            initialState = initialState,
            executorFactory = NewCivilStoreExecutor(),
            reducer = reducer,
            bootstrapper = bootstrapper)
        return object : NewCivilStore, Store<NewCivilStore.Intent, NewCivilStore.State, NewCivilStore.News> by impl
    }
}

private fun createInitialState(): NewCivilStore.State.DefineNumOutput {
    return NewCivilStore.State.DefineNumOutput("")
}