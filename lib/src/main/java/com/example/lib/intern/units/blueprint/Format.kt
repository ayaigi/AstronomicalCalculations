package com.example.lib.intern.units.blueprint

import com.example.lib.intern.units.DMMs

internal fun unitFormat(pattern: UnitFormat, v: AstronomicalUnit): String {
    return v.run {
        val DMMs: DMMs by lazy {
            toDMMs()
        }
        val deci: Double by lazy {
            toDecimal()
        }

        fun int() = deci.toInt()
        fun frac() = (deci - int()).toString().split('.')[1]

        //val match = "DHMSZ"
        val arr = pattern.pattern.toCharArray()
        var final = mutableListOf<String>()

        for (char in arr) {
            final.add(
                when (char) {
                    'D' -> int().toString()
                    'H' -> frac().toString()
                    'M' -> DMMs.min.toString()
                    'S' -> (DMMs.milliSec / 1000).toString()
                    'Z' -> (DMMs.milliSec).toString()
                    else -> char.toString()
                }
            )
        }
        when (pattern.type) {
            1 -> {
                final = final.map {
                    if (it == "°") "h"
                    else it
                }.toMutableList()
            }
            3 -> {
                if (v.value > 0) final.add("N")
                else if (v.value < 0) final.add("S")
            }
            2 -> {
                if (v.value > 0) final.add("E")
                else if (v.value < 0) final.add("W")
            }
        }
        final.joinToString(separator = "")
    }
}

/*
object UnitFormats {
    /**
     * Example: 56° 37''
     */
    val INT_Z_MIN__ = ("D° M''")
    /**
     * Example: 56 37
     */
    val INT_MIN = ("D M")
    /**
     * Example: 56° 37m
     */
    val INT_Z_MINm = ("D° Mm")
    /**
     * Example: 56° 37m 32s
     */
}
 */
class UnitFormat internal constructor(val pattern: String, val type: Int) {
    companion object {
        /**
         * 'D' -> Int
         *
         * 'H' -> Fraction
         *
         * 'M' -> Minute
         *
         * 'S' -> Second
         *
         * 'Z' -> Millisecond
         */
        fun pattern(v: String, type: Int) = UnitFormat(v, type)

        /**
         * Example: 56° 37''
         */
        val INT_Z_MIN__ = ("D° M''")

        /**
         * Example: 56 37
         */
        val INT_MIN = ("D M")

        /**
         * Example: 56° 37m
         */
        val INT_Z_MINm = ("D° Mm")

        /**
         * Example: 56° 37m 32s
         */
        val type_Latitude = 3
        val type_Longitude = 2
        val type_Time = 1
        val type_None = 0
    }
}
