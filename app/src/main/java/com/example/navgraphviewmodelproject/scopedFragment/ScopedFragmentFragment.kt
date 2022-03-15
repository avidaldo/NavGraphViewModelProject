package com.example.navgraphviewmodelproject.scopedFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.ViewModel
import com.example.navgraphviewmodelproject.databinding.FragmentScopedFragmentBinding


class ScopedFragmentFragment : Fragment(R.layout.fragment_scoped_fragment) {
    private lateinit var binding: FragmentScopedFragmentBinding

    /** El ciclo de vida de viewModels tiene como ámbito el fragment,
     * así que cuando el fragment es destruido, también lo es. Por eso
     * al regresar atrás desde este fragment, no se muestra nada en el
     * textview que está observando este viewModel */
    private val vmViewModel : ViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentScopedFragmentBinding.bind(view)

        /** Listener que asigna una lambda al evento de que el text acabe de cambiar */
        binding.etVm.doAfterTextChanged {
            vmViewModel.sampleText.postValue(it.toString())
        }

        /** Elemento de texto que observa el viewmodel */
        vmViewModel.sampleText.observe(viewLifecycleOwner) {
            binding.tvVm.text = it
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_scopedFragment_to_scopedFragmentTwo)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ViewModelFragment", "onDestroy()")
    }

}