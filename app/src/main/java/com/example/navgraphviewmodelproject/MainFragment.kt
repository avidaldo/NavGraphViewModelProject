package com.example.navgraphviewmodelproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.navgraphviewmodelproject.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    private val vmViewModel by viewModels<ViewModel>()
    private val activityVM by activityViewModels<ViewModel>()

    private val navGraphViewModel by navGraphViewModels<ViewModel>(R.id.nav_graph) {
        defaultViewModelProviderFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)

        /** LifeData Observer observando cambios en vmViewModel */
        vmViewModel.sampleText.observe(viewLifecycleOwner) {
            binding.tvVm.text = it
        }

        /** LifeData Observer observando cambios en activityVM */
        activityVM.sampleText.observe(viewLifecycleOwner) {
            binding.tvActivityVm.text = it
        }

        navGraphViewModel.sampleText.observe(viewLifecycleOwner) {
            binding.tvNavgraphVm.text = it
        }

        binding.btnByViewmodels.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_scopedFragmentFragment)
        }

        binding.btnByActivityViewmodels.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_scopedActivityFragment)
        }

        binding.btnByNavgraphViewmodels.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_navigation_sub_navgraph)
        }
    }
}