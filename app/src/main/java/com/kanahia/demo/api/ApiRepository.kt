package com.kanahia.demo.api


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kanahia.demo.models.Data

class ApiRepository(private val ApiService : ApiService) {

    private val liveData =MutableLiveData<Data>()

    val data : LiveData<Data>
    get() = liveData


    suspend fun getRequest(){
        val result = ApiService.getRequest()

        if (result?.body() != null ){
            liveData.postValue(result.body())
        }

    }


}