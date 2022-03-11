package com.sushant.factsapp.factslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sushant.factsapp.models.Facts
import com.sushant.factsapp.network.FactsApiService
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactsRepository @Inject constructor(
    private val factsApiService: FactsApiService
) {

     fun getFacts(): MutableLiveData<Facts> {
        var facts=MutableLiveData<Facts>()
        factsApiService.getFacts().enqueue(object :Callback<Facts>{
            override fun onResponse(call: Call<Facts>, response: Response<Facts>) {
                facts.value= response.body()!!
            }

            override fun onFailure(call: Call<Facts>, t: Throwable) {
              Log.e("FactsRepository","error:${t.toString()}")
            }

        })
        return facts
    }

}