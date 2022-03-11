package com.sushant.factsapp.network


import com.sushant.factsapp.models.Facts
import retrofit2.Call
import retrofit2.http.GET


interface FactsApiService {

    @GET("facts.json")
     fun getFacts(): Call<Facts>
}

