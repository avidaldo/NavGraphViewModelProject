package com.example.navgraphviewmodelproject.viewModels

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.databinding.FragmentViewModelsBinding


class ViewModelsFragment : Fragment(R.layout.fragment_view_models) {
    private lateinit var binding: FragmentViewModelsBinding

    /** El ciclo de vida de viewModels tiene como ámbito el fragment,
     * así que cuando el fragment es destruido, también lo es. Por eso
     * al regresar atrás desde este fragment, no se muestra nada en el
     * textview que está observando este viewModel */
    private val vmViewModel by viewModels<ViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentViewModelsBinding.bind(view)

        /** Listener que asigna una lambda al evento de que el text acabe de cambiar */
        binding.etVm.doAfterTextChanged {
            vmViewModel.sampleText.postValue(it.toString())
        }

        /** Elemento de texto que observa el viewmodel */
        vmViewModel.sampleText.observe(viewLifecycleOwner) {
            binding.tvVm.text = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ViewModelFragment", "onDestroy()")
    }

}