package com.example.materialmotionsample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.transition.Slide
import com.example.materialmotionsample.databinding.FragmentFeature2Binding
import com.google.android.material.transition.MaterialContainerTransform

class Feature2Fragment : Fragment() {

    private lateinit var binding: FragmentFeature2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeature2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*enterTransition = MaterialContainerTransform().apply {
            startView = requireActivity().findViewById(R.id.fab)
            endView = binding.frameLayout
            duration = 300L
            setAllContainerColors(ContextCompat.getColor(requireContext(), R.color.reply_blue_50))
        }
        returnTransition = Slide().apply {
            duration = 300L
            addTarget(binding.frameLayout)
        }*/

    }



}