package com.kanahia.demo.models




import com.google.gson.annotations.SerializedName


data class Dema(

    @SerializedName("data" ) var data : ArrayList<String> = arrayListOf()

)