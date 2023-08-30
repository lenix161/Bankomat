package com.example.bankomatsimulator.activities

import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankomatsimulator.PowerReceiver
import com.example.bankomatsimulator.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUIBehavior()
        loadBankAccount()
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(PowerReceiver(), filter)

        loadBankAccount()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(PowerReceiver())
    }

    private fun loadBankAccount() {
        prefs = getSharedPreferences("settings", MODE_PRIVATE)

        binding.rubValue.text = prefs.getFloat("RUB", 0F).toString()
        binding.usdValue.text = prefs.getFloat("USD", 0F).toString()
        binding.eurValue.text = prefs.getFloat("EUR", 0F).toString()
    }

    private fun setUIBehavior() {
        binding.getMoneyBtn.setOnClickListener {
            val intent = Intent(this, GetMoneyActivity::class.java)
            startActivity(intent)
        }

        binding.addMoneyBtn.setOnClickListener {
            val intent = Intent(this, AddMoneyActivity::class.java)
            startActivity(intent)
        }

        binding.listBtn.setOnClickListener {
            val intent = Intent(this, CurrenciesListActivity::class.java)
            startActivity(intent)
        }

        binding.exchangeButton.setOnClickListener {
            val intent = Intent(this, ExchangeActivity::class.java)
            startActivity(intent)
        }
    }
}