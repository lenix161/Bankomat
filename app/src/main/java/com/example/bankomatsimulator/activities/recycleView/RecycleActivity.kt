package com.example.bankomatsimulator.activities.recycleView

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankomatsimulator.activities.App
import com.example.bankomatsimulator.databinding.ActivityListBinding

class RecycleActivity: AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: CurrencyAdapter

    private val currencyService: CurrencyService
        get() = (applicationContext as App).currencyService

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CurrencyAdapter()

        val layoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = layoutManager
        binding.recycleView.adapter = adapter
    }
}