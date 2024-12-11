package com.adnan.kotlinkoin.repositary

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.adnan.kotlinkoin.model.responseModel.CategoryItem
import com.adnan.kotlinkoin.model.responseModel.Category
import com.adnan.kotlinkoin.network.ApiInterface
import com.adnan.kotlinkoin.network.BaseCallBack
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.lang.reflect.Type

class HomeRepo(private var apiInterface: ApiInterface) {
    fun userLoginApiCall(id: Int?): MutableLiveData<Category> {
        val userLoginResponse = MutableLiveData<Category>()
        val call = apiInterface.homeApiCall(id = id)
//        Log.e("HTTP Request", " " + call?.request().toString())

        call?.enqueue(object : BaseCallBack<ResponseBody>(call) {
            override fun onFinalSuccess(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {

                val type: Type = object : TypeToken<List<CategoryItem>>() {}.type
                val jsonString = response.body()?.string()
                val list = Gson().fromJson<List<CategoryItem>>(jsonString, type)

                userLoginResponse.value = Category().apply {
                    this.categoryList=list
                }
            }


            override fun onFinalFailure(
                errorString: String?
            ) {

                Log.e("API Failure", " $errorString")

                userLoginResponse.value = Category().apply {
                    this.categoryList = arrayListOf()
                    this.status = false
                    this.message = errorString
                }


            }

        })

        return userLoginResponse
    }


}