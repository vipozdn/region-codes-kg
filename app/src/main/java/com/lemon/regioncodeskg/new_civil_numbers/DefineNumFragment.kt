package com.lemon.regioncodeskg.new_civil_numbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.arkivanov.mvikotlin.core.binder.Binder
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.lemon.regioncodeskg.R
import com.lemon.regioncodeskg.new_civil_numbers.composable.ContentView
import com.lemon.regioncodeskg.new_civil_numbers.store.NewCivilStore
import com.lemon.regioncodeskg.new_civil_numbers.store.NewCivilStoreFactory
import kotlinx.coroutines.flow.transform

class DefineNumFragment : Fragment(R.layout.fragment_define_num) {

    private val viewModelFactory = NewCivilViewModel.factory
    private lateinit var viewModel: NewCivilViewModel
    private val store = NewCivilStoreFactory.create(DefaultStoreFactory())
    private var binder: Binder? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[NewCivilViewModel::class.java]

        return ComposeView(requireContext()).apply {
            setContent {
                val state: ViewModelState by viewModel.states.collectAsState(ViewModelState())
                ContentView(state) { event ->
                    viewModel.onEvent(event)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binder = bind(viewModel.viewModelScope.coroutineContext) {
            store.states.transform<NewCivilStore.State, ViewModelState> { stateToModel } bindTo viewModel::onState
            viewModel.uiEvents.transform<UiEvent, NewCivilStore.Intent> { eventToIntent } bindTo store
        }
        binder?.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binder?.stop()
    }

}