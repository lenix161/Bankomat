package com.example.bankomatsimulator.activities.recycleView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankomatsimulator.databinding.ActivityListBinding

class RecycleActivity: AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CurrencyAdapter()

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter
    }
}