package com.kanahia.demo.api

import com.kanahia.demo.Datam
import com.kanahia.demo.models.Data
import com.kanahia.demo.models.Dema
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    @POST("/run/predict")
    suspend fun createPost(@Body dataModal: Dema?): Response<Datam?>?


}