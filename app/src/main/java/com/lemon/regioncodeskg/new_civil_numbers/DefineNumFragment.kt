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
import com.lemon.regioncodeskg.R
import com.lemon.regioncodeskg.ui.composable.new_civil_numbers.ContentView

class DefineNumFragment : Fragment(R.layout.fragment_define_num) {

    private val viewModelFactory = NewCivilViewModel.factory
    private lateinit var viewModel: NewCivilViewModel;

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

}