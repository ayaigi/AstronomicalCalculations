package com.example.astronomicalcalculations.intern.units

data class DMMs(val sign: Int = 1, val int: Int, val min: Int, val milliSec: Int) {
    constructor(sign: Double = 1.0, int: Int, min: Int, milliSec: Int) : this(sign.toInt(), int, min, milliSec)
}