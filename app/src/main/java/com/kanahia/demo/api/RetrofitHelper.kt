package com.kanahia.demo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val BASE_URL ="https://segadeds-medical-diagnosis.hf.space/run/predict/"

    fun getInstance() : Retrofit{
        return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

    }


}