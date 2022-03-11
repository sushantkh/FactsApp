package com.sushant.factsapp.factslist

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sushant.factsapp.models.Facts
import com.sushant.factsapp.application.FactsApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FactsViewModel @Inject constructor(
    private val factsApplication: FactsApplication,
    private val factsRepository: FactsRepository
) : AndroidViewModel(factsApplication) {
    lateinit var factsList: LiveData<Facts>


    fun getFacts(): LiveData<Facts> {
        factsList = factsRepository.getFacts()
        return factsList
    }


}