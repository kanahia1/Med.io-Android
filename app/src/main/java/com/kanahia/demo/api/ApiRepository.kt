package com.kanahia.demo.api


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kanahia.demo.Datam
import com.kanahia.demo.models.Data
import com.kanahia.demo.models.Dema

class ApiRepository(private val ApiService : ApiService) {

    private val liveData =MutableLiveData<Datam>()

    val data : LiveData<Datam>
    get() = liveData


    suspend fun postRequest(d : Dema){
        val result = ApiService.createPost(d)



        if (result?.body() != null ){
            liveData.postValue(result.body())
        }else{
            Log.e("PRINT",result!!.toString())
        }


    }


}

