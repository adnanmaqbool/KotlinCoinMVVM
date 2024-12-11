package com.adnan.kotlincoin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.adnan.kotlincoin.model.responseModel.Category
import com.adnan.kotlincoin.repositary.HomeRepo
import com.axelliant.hris.event.Event

class HomeViewModel(private val loginRepo: HomeRepo) : BaseViewModel() {
    val categoryListResponse: MutableLiveData<Event<Category?>> by lazy { MutableLiveData<Event<Category?>>() }


    fun listApi(id: Int) {

        isLoading.value = Event(true)
        loginRepo.userLoginApiCall(id)
            .observeForever { data ->
                // Handle the login response
                data?.let { recipeList ->
                    isLoading.value = Event(false)
                    categoryListResponse.value = Event(recipeList)

                } ?: run {
                    isLoading.value = Event(false)
                    categoryListResponse.value= Event(data)

                }
            }

    }


}