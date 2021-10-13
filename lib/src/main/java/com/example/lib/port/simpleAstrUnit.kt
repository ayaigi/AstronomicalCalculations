package com.example.astronomicalcalculations.port

import com.example.astronomicalcalculations.intern.units.Degrees
import com.example.astronomicalcalculations.intern.units.blueprint.astrUnit


public class simpleAstrUnit internal constructor(val milliSecs: Long){
    fun value() = milliSecs
    fun intValue() = milliSecs.toInt()
    fun toDecimal() = astrUnit(milliSecs).toDecimal()
    fun format(pattern: String) = astrUnit(milliSecs).toString(pattern)
    override fun toString(): String {
        return format("D.H")
    }

    companion object {
        fun fromDecimal(v: Double) = simpleAstrUnit(Degrees.fromDecimal(v).value)
        fun fromDecimal(v: Int) = simpleAstrUnit(Degrees.fromDecimal(v).value)
        fun fromInt(v: Int) = simpleAstrUnit(v.toLong())
    }
}