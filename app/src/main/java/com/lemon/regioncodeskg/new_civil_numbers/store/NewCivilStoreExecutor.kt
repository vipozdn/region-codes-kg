package com.lemon.regioncodeskg.new_civil_numbers.store

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor

class NewCivilStoreExecutor :
    CoroutineExecutor<NewCivilStore.Intent, Action, NewCivilStore.State, Message, NewCivilStore.News>() {


    override fun executeAction(action: Action, getState: () -> NewCivilStore.State) {

        return when (action) {
            is Action.HandleIntent -> executeIntent(action.intent, getState)
            is Action.DefineNumInput -> defineNumInput(getState(), action.newCivilIds)
        }

    }

    override fun executeIntent(intent: NewCivilStore.Intent, getState: () -> NewCivilStore.State) {
        return when(intent) {
            is NewCivilStore.Intent.DefineNum -> defineNumInput(getState(), intent.newCivilIds)
        }
    }

    private fun defineNumInput(state: NewCivilStore.State, newCivilIds: List<String>) {
        if (state !is NewCivilStore.State.DefineNumOutput) return
        dispatch(Message.DefineNumResult(newCivilIds))
    }

}