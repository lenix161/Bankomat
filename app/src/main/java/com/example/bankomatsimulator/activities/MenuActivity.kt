package com.example.bankomatsimulator.activities

import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankomatsimulator.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences("settings", MODE_PRIVATE)

        binding.rubValue.text = prefs.getInt("RUB", 0).toString()
        binding.usdValue.text = prefs.getInt("USD", 0).toString()
        binding.eurValue.text = prefs.getInt("EUR", 0).toString()

        binding.balanceBtn.setOnClickListener {
            val intent = Intent(this , CurrencyActivity::class.java)
            startActivity(intent)
        }

        binding.getMoneyBtn.setOnClickListener {
            val intent = Intent(this, GetMoneyActivity::class.java)
            startActivity(intent)
        }

        binding.addMoneyBtn.setOnClickListener {
            val intent = Intent(this, AddMoneyActivity::class.java)
            startActivity(intent)
        }

        binding.listBtn.setOnClickListener {
            val intent = Intent(this, RecycleActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(PowerReceiver(), filter)

        prefs = getSharedPreferences("settings", MODE_PRIVATE)

        binding.rubValue.text = prefs.getInt("RUB", 0).toString()
        binding.usdValue.text = prefs.getInt("USD", 0).toString()
        binding.eurValue.text = prefs.getInt("EUR", 0).toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(PowerReceiver())
    }
}