package com.adnan.kotlincoin

import android.app.Application
import com.adnan.kotlincoin.dependency_injection.factoryModule
import com.adnan.kotlincoin.dependency_injection.singletonModule
import com.adnan.kotlincoin.dependency_injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(singletonModule, viewModelModule, factoryModule))
        }
    }
}