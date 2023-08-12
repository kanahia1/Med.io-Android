package com.kanahia.demo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val BASE_URL ="https://751a-2401-4900-3e46-2d09-1d8d-8f17-bb70-ebeb.ngrok-free.app/"

    fun getInstance() : Retrofit{
        return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

    }


}