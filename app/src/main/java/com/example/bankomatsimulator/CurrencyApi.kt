package com.example.bankomatsimulator

import com.example.bankomatsimulator.currencyresponse.CurrencyResponse
import retrofit2.http.GET

interface CurrencyApi {

    @GET("./daily_json.js")
    suspend fun getCurrencies(): CurrencyResponse
}