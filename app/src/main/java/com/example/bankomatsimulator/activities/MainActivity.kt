package com.example.bankomatsimulator.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.example.bankomatsimulator.Data
import com.example.bankomatsimulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Data.initializeRetrofit()
        Data.getCurrencies()

        setUI()
    }
    private fun setUI() {
        binding.loadingView.visibility = View.INVISIBLE

        binding.logo.animate()
            .scaleX(0.7f)
            .scaleY(0.7f)
            .setDuration(1000)



        binding.insertCardBtn.setOnClickListener {
            binding.waitTextView.text = "Ожидайте"
            loadingAnimation(binding.loadingView)
            binding.insertCardBtn.animate()
                .alpha(0f)
                .setDuration(1000)
                .start()
            val handler = Handler()
            handler.postDelayed({
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        }
    }

    private fun loadingAnimation(view: ImageView) {
        view.visibility = View.VISIBLE
        view.animate()
            .rotationBy(-360f)
            .setDuration(3000)
            .start()
    }
}