package com.adnan.kotlincoin.screens.activities

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.adnan.kotlincoin.R
import com.adnan.kotlincoin.dependency_injection.Components

class MainActivity : BaseActivity() {
    private lateinit var diComponents: Components

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diComponents = Components()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // above will assign it
        diComponents.globalConfig.navController = navHostFragment.navController
        diComponents.globalConfig.navController.addOnDestinationChangedListener { controller, destination, arguments ->


            // do some task when fragment changes ?
        }



    }

}

