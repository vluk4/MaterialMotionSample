package com.example.materialmotionsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.materialmotionsample.databinding.ActivityMainBinding
import com.google.android.material.transition.MaterialElevationScale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val currentNavigationFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.childFragmentManager
            ?.fragments
            ?.first()

    private val listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        when(destination.id) {
            R.id.homeFragment -> {
                binding.fab.show()
            }
            R.id.featureFragment -> {
                binding.fab.hide()
            }
            R.id.feature2Fragment -> {
                binding.fab.hide()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.apply {
            setShowMotionSpecResource(R.animator.fab_show)
            setHideMotionSpecResource(R.animator.fab_hide)
            setOnClickListener {
                /*currentNavigationFragment?.apply {
                    exitTransition = MaterialElevationScale(false).apply {
                        duration = 300L
                    }
                    reenterTransition = MaterialElevationScale(true).apply {
                        duration = 300L
                    }
                }*/
                val directions = Feature2FragmentDirections.actionGlobalFeature2Fragment()
                findNavController(R.id.nav_host_fragment).navigate(directions)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        findNavController(R.id.nav_host_fragment).removeOnDestinationChangedListener(listener)
        super.onPause()
    }
}