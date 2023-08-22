package com.example.bankomatsimulator.currencyresponse

data class CurrencyResponse(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Valute
)