package com.adnan.kotlinkoin.dependency_injection

import com.adnan.kotlinkoin.config.GlobalConfig
import com.axelliant.hris.di.TestModelInjection
import com.adnan.kotlinkoin.network.ApiInterface
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Components :KoinComponent{
    val testModelInjection: TestModelInjection by inject()
    val globalConfig : GlobalConfig by inject()
    val apiInterface : ApiInterface by inject()

}