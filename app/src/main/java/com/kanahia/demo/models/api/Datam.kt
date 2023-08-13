package com.kanahia.demo

import com.google.gson.annotations.SerializedName


data class Datam (

  @SerializedName("data"             ) var data            : ArrayList<LabelData> = arrayListOf(),
  @SerializedName("is_generating"    ) var isGenerating    : Boolean?        = null,
  @SerializedName("duration"         ) var duration        : Double?         = null,
  @SerializedName("average_duration" ) var averageDuration : Double?         = null

)