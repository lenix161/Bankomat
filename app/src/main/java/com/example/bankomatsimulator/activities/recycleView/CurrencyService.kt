package com.example.bankomatsimulator.activities.recycleView

class CurrencyService {

    private var currencies = mutableListOf<Currency>()

    init {
        currencies = (1..100).map {Currency(
            icon = "",
            name = "USD",
            cost = 10.000
        )}.toMutableList()
    }

    fun getCurrencies(): List<Currency>{
        return currencies
    }
}