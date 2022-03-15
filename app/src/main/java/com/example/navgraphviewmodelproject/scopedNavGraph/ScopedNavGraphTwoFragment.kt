package com.example.navgraphviewmodelproject.scopedNavGraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.navGraphViewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.ViewModel
import com.example.navgraphviewmodelproject.databinding.FragmentScopedNavGraphTwoBinding


class ScopedNavGraphTwoFragment : Fragment(R.layout.fragment_scoped_nav_graph_two) {

    private lateinit var binding: FragmentScopedNavGraphTwoBinding
    private val navGraphViewModel by navGraphViewModels<ViewModel>(R.id.sub_nav_graph) {
        defaultViewModelProviderFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentScopedNavGraphTwoBinding.bind(view)

        navGraphViewModel.sampleText.observe(viewLifecycleOwner) {
            binding.tvVm.text = it
        }
    }

}