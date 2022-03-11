package com.example.materialmotionsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.materialmotionsample.databinding.FragmentHomeBinding
import com.google.android.material.transition.MaterialElevationScale

val sampleList = listOf(
    Sample(
        id = 1,
        title = "Package Shipped!",
        description = "Cucumber mask facial has shipped. It'll be on your front door by the end of the week!"
    ),
    Sample(
        id = 2,
        title = "Brunch this weekend?",
        description = "I'll be in your neighborhood doing errands and was hoping to catch you for a coffee this Saturday. If you don't have anything scheduled, it would be great to see you! It feels like its been forever"
    ),
    Sample(
        id = 3,
        title = "Brazil trip",
        description = "Thought we might be able to go over some details about our upcoming vacation."
    )
)

class HomeFragment : Fragment(), OnSampleClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val sampleAdapter: SampleListAdapter by lazy { SampleListAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        binding.apply {
            rvHome.adapter = sampleAdapter
            sampleAdapter.submitList(sampleList)
        }
    }

    override fun onCardSelected(cardView: View) {
       /* exitTransition = MaterialElevationScale(false).apply {
            duration = 300L
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = 300L
        }*/

        /*val emailCardDetailTransitionName = getString(R.string.email_card_detail_transition_name)
        val extras = FragmentNavigatorExtras(cardView to emailCardDetailTransitionName)*/
        val directions = HomeFragmentDirections.actionHomeFragmentToFeatureFragment()
        findNavController().navigate(directions)
    }
}