package com.example.bankomatsimulator.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankomatsimulator.databinding.ActivityGetMoneyBinding

class GetMoneyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetMoneyBinding
    private lateinit var prefs: SharedPreferences

    var cur = ""
    var value = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGetMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()

        binding.chooseCurrencySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)
                cur = item.toString()
                binding.valuteTitle.text = "$cur: "
                binding.valuteValue.text = prefs.getFloat(cur, 0F).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.valuteTitle.text = "RUB: "
        binding.valuteValue.text = prefs.getFloat("RUB", 0F).toString()

        binding.applyBtn.setOnClickListener {
            if (binding.editSum.length() > 0){
                val a = binding.editSum.text.toString().toFloat()
                if (a > 0){
                    value = prefs.getFloat(cur, 0F)
                    if (value - a < 0){
                        val toast = Toast.makeText(this, "На счете недостаточно седств",
                            Toast.LENGTH_SHORT)
                        toast.show()
                    } else {
                        value -= a
                        editor.putFloat(cur, value)
                        editor.apply()
                        binding.valuteTitle.text = "$cur: "
                        binding.valuteValue.text = prefs.getFloat(cur, 0F).toString()
                        binding.editSum.text.clear()
                        val toast =
                            Toast.makeText(this, "Со счета снято $a $cur", Toast.LENGTH_SHORT)
                        toast.show()
                    }
                }else {
                    val toast = Toast.makeText(this, "Неправильно введена сумма", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }else{
                val toast = Toast.makeText(this, "Неправильно введена сумма", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        binding.backBtn.setOnClickListener {
            finish()
        }


    }
}