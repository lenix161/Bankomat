package com.example.bankomatsimulator.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.bankomatsimulator.Data
import com.example.bankomatsimulator.databinding.ActivityExchangeMoneyBinding


class ExchangeActivity : AppCompatActivity() {
    private var curFrom = ""
    private var curTo = ""
    private lateinit var binding: ActivityExchangeMoneyBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExchangeMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences("settings", MODE_PRIVATE)

        setUI(this)

    }


    private fun setUI(context: Context) {

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.fromChooseCurrencySpinner
            .onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)
                curFrom = item.toString()

                if (curFrom == "RUB") {
                    binding.toChooseCurrencySpinner.adapter =
                        ArrayAdapter<String>(
                            context,
                            android.R.layout.simple_spinner_dropdown_item,
                            listOf("USD", "EUR")
                        )
                } else {
                    binding.toChooseCurrencySpinner.adapter =
                        ArrayAdapter<String>(
                            context,
                            android.R.layout.simple_spinner_dropdown_item,
                            listOf("RUB")
                        )
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.toChooseCurrencySpinner
            .onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)
                curTo = item.toString()
                Log.i("MyLog", "cur to: $curTo")
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.fromEditText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (!p0.isNullOrEmpty()){
                    val inputted = p0.toString().toDouble()
                    var result = 0.0
                    if (curTo == "USD") {
                        result = inputted / Data.currencyResponse.Valute.USD.Value
                    } else if (curTo == "EUR") {
                        result = inputted / Data.currencyResponse.Valute.EUR.Value
                    } else {
                        if (curFrom == "USD") {
                            result = inputted * Data.currencyResponse.Valute.USD.Value
                        } else if (curFrom == "EUR") {
                            result = inputted * Data.currencyResponse.Valute.EUR.Value
                        }
                    }

                    binding.toEditText.setText(result.toString())
                } else {
                    binding.toEditText.setText("")
                }
            }
        })
    }
}
