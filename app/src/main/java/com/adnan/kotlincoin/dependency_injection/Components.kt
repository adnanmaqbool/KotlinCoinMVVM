package com.adnan.kotlincoin.dependency_injection

import com.adnan.kotlincoin.config.GlobalConfig
import com.axelliant.hris.di.TestModelInjection
import com.adnan.kotlincoin.network.ApiInterface
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Components :KoinComponent{
    val testModelInjection: TestModelInjection by inject()
    val globalConfig : GlobalConfig by inject()
    val apiInterface : ApiInterface by inject()

}