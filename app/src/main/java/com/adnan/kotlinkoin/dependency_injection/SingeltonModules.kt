package com.adnan.kotlinkoin.dependency_injection

import com.adnan.kotlinkoin.config.GlobalConfig
import com.adnan.kotlinkoin.network.ApiHandler
import com.adnan.kotlinkoin.repositary.HomeRepo
import com.adnan.kotlinkoin.session.SessionManager
import com.adnan.kotlinkoin.viewmodel.BaseViewModel
import com.adnan.kotlinkoin.viewmodel.HomeViewModel
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