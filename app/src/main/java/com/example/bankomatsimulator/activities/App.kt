package com.example.bankomatsimulator.activities

import android.app.Application
import com.example.bankomatsimulator.activities.recycleView.CurrencyService

class App: Application() {
    val currencyService = CurrencyService()
}