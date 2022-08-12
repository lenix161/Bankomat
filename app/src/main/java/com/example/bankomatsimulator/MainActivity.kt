package com.example.bankomatsimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.bankomatsimulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.insertCardBtn.setOnClickListener {
            binding.waitTextView.text = "Ожидайте"
            val handler = Handler()
            handler.postDelayed({
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        }
    }
}