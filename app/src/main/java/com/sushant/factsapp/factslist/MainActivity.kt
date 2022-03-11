package com.sushant.factsapp.factslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sushant.factsapp.databinding.ActivityMainBinding
import com.sushant.factsapp.models.Rows
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var factsViewModel: FactsViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvFacts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
        setUpViewModel()
    }

    private fun setUpUI() {
        rvFacts = binding.rvFacts
       //rvFacts.setHasFixedSize(true)
        var layoutManager=LinearLayoutManager(this)
        layoutManager.isAutoMeasureEnabled=true
        rvFacts.layoutManager = layoutManager
    }

    private fun setUpViewModel() {
        factsViewModel = ViewModelProvider(this)[FactsViewModel::class.java]

        factsViewModel.getFacts().observe(this, {
            Log.e("Main", "facts:$it")
            displayData(it.rows)
        })
    }

    private fun displayData(list: List<Rows>) {
        val mAdapter = FactsAdapter(list)
        rvFacts.adapter = mAdapter
    }
}