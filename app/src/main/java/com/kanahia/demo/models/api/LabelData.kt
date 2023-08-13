package com.kanahia.demo

import com.google.gson.annotations.SerializedName


data class LabelData (

  @SerializedName("label"       ) var label       : String?                = null,
  @SerializedName("confidences" ) var confidences : ArrayList<Confidences> = arrayListOf()

)