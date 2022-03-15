package com.example.navgraphviewmodelproject.scopedNavGraph

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.ViewModel
import com.example.navgraphviewmodelproject.databinding.FragmentScopedNavGraphBinding


class ScopedNavGraphFragment : Fragment(R.layout.fragment_scoped_nav_graph) {
    private lateinit var binding: FragmentScopedNavGraphBinding


    /** El ciclo de vida de navGraphViewModels tiene como ámbito la el navGraph,
     * mantendrá el viewModel al pasar al fragment destino, pero no al regresar a
     * MainFragment. */
    private val navGraphViewModel
            by navGraphViewModels<ViewModel>(R.id.sub_nav_graph) {
                defaultViewModelProviderFactory
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentScopedNavGraphBinding.bind(view)

        binding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_scoped_nav_graph_fragment_to_fragment_scoped_nav_graph_two)
        }

        binding.etVm.doAfterTextChanged {
            navGraphViewModel.sampleText.postValue(it.toString())
        }

        navGraphViewModel.sampleText.observe(viewLifecycleOwner) {
            binding.tvVm.text = it
        }
    }
}