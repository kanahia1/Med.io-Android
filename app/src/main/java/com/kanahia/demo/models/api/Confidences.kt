package com.kanahia.demo

import com.google.gson.annotations.SerializedName


data class Confidences (

  @SerializedName("label"      ) var label      : String? = null,
  @SerializedName("confidence" ) var confidence : Double? = null

)