package uc.team.lotinkiril

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import uc.team.lotinkiril.databinding.FragmentHomePageBinding


class HomePage : Fragment() {
    private val binding by lazy{ FragmentHomePageBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.apply {
            uzbekKiril.setOnClickListener {
                findNavController().navigate(R.id.homeToConvertText, bundleOf("uzbekkiril" to 0))
            }
            kirilUzbek.setOnClickListener {
                findNavController().navigate(R.id.homeToConvertText, bundleOf("uzbekkiril" to 1))
            }
        }

        return binding.root
    }

}