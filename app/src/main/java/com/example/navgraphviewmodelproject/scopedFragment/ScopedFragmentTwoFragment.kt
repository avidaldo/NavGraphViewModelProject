package com.example.navgraphviewmodelproject.scopedFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.ViewModel
import com.example.navgraphviewmodelproject.databinding.FragmentScopedFragmentTwoBinding


class ScopedFragmentTwoFragment : Fragment(R.layout.fragment_scoped_nav_graph_two) {
    private lateinit var binding: FragmentScopedFragmentTwoBinding

    private val vmViewModel : ViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentScopedFragmentTwoBinding.bind(view)

        vmViewModel.sampleText.observe(viewLifecycleOwner) {
            binding.tvVm.text = it
        }
    }
}