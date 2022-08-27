package com.example.bankomatsimulator.activities.recycleView

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.bankomatsimulator.R
import org.json.JSONObject

object Data {


    var curList = mutableListOf<CurrencyModel>()

    fun getInternetData(cur: String, context: Context){
        val url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/$cur/rub.json"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(Request.Method.GET, url,
            {
                    response->
                val result = JSONObject(response).getString("rub")
                if(cur == "usd") {
                    curList.add(CurrencyModel(R.drawable.ic_baseline_attach_money_24, "USD", result.toDouble()))
                } else
                    curList.add(CurrencyModel(R.drawable.ic_euro_icon, "EUR", result.toDouble()))
                Log.d("power", "Result: $curList")
                //val result =JSONObject(response).getJSONObject()
            },
            {
                Log.d("power", "Volley error: $it")
            })
        queue.add(stringRequest)
    }






}