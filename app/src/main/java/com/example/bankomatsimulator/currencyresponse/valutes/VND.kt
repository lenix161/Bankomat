package com.example.bankomatsimulator.currencyresponse.valutes

data class VND(
    val CharCode: String,
    val ID: String,
    val Name: String,
    val Nominal: Int,
    val NumCode: String,
    val Previous: Double,
    val Value: Double
)