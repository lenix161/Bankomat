package com.example.bankomatsimulator.activities

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.bankomatsimulator.databinding.ActivityCurrencyBinding


class CurrencyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCurrencyBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        prefs = getSharedPreferences("settings", MODE_PRIVATE)

        binding.rubValue.text = prefs.getInt("RUB", 0).toString()
        binding.usdValue.text = prefs.getInt("USD", 0).toString()
        binding.eurValue.text = prefs.getInt("EUR", 0).toString()

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}