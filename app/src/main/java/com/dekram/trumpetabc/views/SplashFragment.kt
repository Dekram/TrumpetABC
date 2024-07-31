package com.dekram.trumpetabc.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.dekram.trumpetabc.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        view?.let { initView(it) }
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.splashScreen)
        val delayTime: Long = 5000

//        view.postDelayed({
//            findNavController().navigate(
//                R.id.action_splash_fragment_to_home_fragment,
//                bundleOf(),
//                navOptions {
//                    anim {
//                        enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
//                        popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
//                        popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
//                        exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
//                    }
//                }
//            )
//        }, delayTime)
    }

    private fun initView(view: View) {
        view.findViewById<ImageView>(R.id.splashScreen)
        Log.d("Splash Screen init", "initialization done")
    }
}