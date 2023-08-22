package com.example.bankomatsimulator

import com.example.bankomatsimulator.currencyresponse.CurrencyResponse
import com.example.bankomatsimulator.recycleView.CurrencyModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Data {
    var curList = mutableListOf<CurrencyModel>()
    lateinit var currencyApi: CurrencyApi
    lateinit var currencyResponse: CurrencyResponse

    private var isRetrofitInitialized = false

    fun initializeRetrofit(){
        if (!isRetrofitInitialized) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            currencyApi = retrofit.create(CurrencyApi::class.java)

            isRetrofitInitialized = true
        }
    }

    fun getCurrencies(){
        CoroutineScope(Dispatchers.IO).launch{
            currencyResponse = currencyApi.getCurrencies()

            curList.add(
                CurrencyModel(
                    R.drawable.ic_baseline_attach_money_24,
                    "USD",
                    currencyResponse.Valute.USD.Value
                )
            )

            curList.add(
                CurrencyModel(
                    R.drawable.ic_euro_icon,
                    "EUR",
                    currencyResponse.Valute.EUR.Value
                )
            )
        }
    }
}