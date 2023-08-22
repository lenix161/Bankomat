package com.example.bankomatsimulator.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankomatsimulator.databinding.ActivityListBinding
import com.example.bankomatsimulator.recycleView.CurrencyAdapter
import com.example.bankomatsimulator.Data

class CurrenciesListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actualTimeStamp = Data.currencyResponse.Timestamp
        val year = actualTimeStamp.slice(0..3)
        val month = actualTimeStamp.slice(5..6)
        val date = actualTimeStamp.slice(8..9)
        val time = actualTimeStamp.slice(11..15)

        binding.actualTime.text = "$time $date.$month.$year"

        adapter = CurrencyAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}