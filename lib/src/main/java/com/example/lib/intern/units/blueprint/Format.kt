package com.example.lib.intern.units.blueprint

import com.example.lib.intern.units.DMMs

internal fun unitFormat(pattern: UnitFormat, v: AstronomicalUnit) : String{
    return v.run{
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
        final.joinToString(separator = "")
    }
}

object UnitFormats {
    /**
     * Example: 56 37
     */
    val INT_MIN = UnitFormat("D M")
    /**
     * Example: 56° 37m
     */
    val INTd_MINm = UnitFormat("D M")
    /**
     * Example: 16h 37m
     */
    val INTh_MINm = UnitFormat("D M")
}
class UnitFormat(val pattern: String) {
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
        fun pattern(v: String) = UnitFormat(v)
    }
}