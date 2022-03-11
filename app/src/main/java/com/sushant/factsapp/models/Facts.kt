package com.sushant.factsapp.models

import com.google.gson.annotations.SerializedName


data class Facts (

  @SerializedName("title" ) var title : String?         = null,
  @SerializedName("rows"  ) var rows  : ArrayList<Rows> = arrayListOf()

)