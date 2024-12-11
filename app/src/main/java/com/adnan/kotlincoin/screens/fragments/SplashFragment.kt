package com.adnan.kotlincoin.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.adnan.kotlincoin.databinding.FragmentSplashBinding
import com.adnan.kotlincoin.navigation.AppNavigator
import com.adnan.kotlincoin.session.SessionManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class SplashFragment : BaseFragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding

    private val sessionManager: SessionManager by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater).also { _binding = it }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(2000) // 2 seconds delay
            // Code to execute after delay
            AppNavigator.navigateToHome()
        }

    }



}