package com.adnan.kotlincoin.dependency_injection

import com.adnan.kotlincoin.config.GlobalConfig
import com.adnan.kotlincoin.network.ApiHandler
import com.adnan.kotlincoin.repositary.HomeRepo
import com.adnan.kotlincoin.session.SessionManager
import com.adnan.kotlincoin.viewmodel.BaseViewModel
import com.adnan.kotlincoin.viewmodel.HomeViewModel
import com.axelliant.hris.di.TestModelInjection
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val singletonModule = module {
    single { TestModelInjection() }
    single { GlobalConfig.getInstance() }
    single { ApiHandler.getApiInterface() }
    single { SessionManager(androidContext()) }

}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { BaseViewModel() }

}

val factoryModule = module {
    factory { HomeRepo(get()) }

}