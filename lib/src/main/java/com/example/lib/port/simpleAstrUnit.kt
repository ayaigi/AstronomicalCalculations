package com.example.lib.port

import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.blueprint.AstronomicalUnit
import com.example.lib.intern.units.blueprint.UnitFormat

@Deprecated(message = "", level = DeprecationLevel.WARNING)
public class simpleAstrUnit internal constructor(val milliSecs: Long){
    fun value() = milliSecs
    fun intValue() = milliSecs.toInt()
    fun toDecimal() = AstronomicalUnit(milliSecs).toDecimal()
    fun format(pattern: String) = AstronomicalUnit(milliSecs).toString(UnitFormat(pattern, UnitFormat.type_None))
    override fun toString(): String {
        return format("D.H")
    }

    companion object {
        fun fromDecimal(v: Double) = simpleAstrUnit(Degrees.fromDecimal(v).value)
        fun fromDecimal(v: Int) = simpleAstrUnit(Degrees.fromDecimal(v).value)
        fun fromInt(v: Int) = simpleAstrUnit(v.toLong())
    }
}