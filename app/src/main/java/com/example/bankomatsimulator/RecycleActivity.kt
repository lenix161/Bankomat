package com.example.bankomatsimulator

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.bankomatsimulator.databinding.ActivityListBinding

class RecycleActivity: AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = mutableListOf<String>("раз", "два", "три")




    }
}