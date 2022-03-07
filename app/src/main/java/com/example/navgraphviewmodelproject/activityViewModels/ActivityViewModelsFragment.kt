package com.example.navgraphviewmodelproject.activityViewModels

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.navgraphviewmodelproject.R
import com.example.navgraphviewmodelproject.databinding.FragmentActivityViewModelsBinding


class ActivityViewModelsFragment : Fragment(R.layout.fragment_activity_view_models) {
    private lateinit var binding: FragmentActivityViewModelsBinding

    /** El ciclo de vida de activityViewModels tiene como ámbito la activity,
     * así que cuando el fragment es destruido, el viewmodel se mantiene. Por eso
     * al regresar atrás desde este fragment, se muestra el texto introducido
     * en el textView que lo está observando. Este tipo de ViewModel
     * es útil para compartir datos entre multiples fragments. Del mismo
     * modo, si después de estar en MainFragment volvemos a este fragment
     * se sigue manteniendo. */
    private val activityVM by activityViewModels<ActivityViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentActivityViewModelsBinding.bind(view)

        binding.etVm.doAfterTextChanged {
            activityVM.sampleText.postValue(it.toString())
        }

        activityVM.sampleText.observe(viewLifecycleOwner) {
            binding.tvVm.text = it
        }
    }

}