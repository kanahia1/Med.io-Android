package com.kanahia.demo.api

import com.kanahia.demo.models.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {


    @GET("/articles")
    suspend fun getRequest():Response<Data>



}