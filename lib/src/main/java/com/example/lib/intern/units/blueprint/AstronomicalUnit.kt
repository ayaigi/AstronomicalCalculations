package com.example.lib.intern.units.blueprint

import com.example.lib.intern.units.DMMs
import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.deg
import kotlin.math.abs
import kotlin.math.sign

open class AstronomicalUnit(override var value: Long) : astrUnitInter {
    internal constructor(value: Double) : this(value.toLongExept())

    override fun toString(): String {
        return toDecimal().toString()
        //return toDMMs().run { "$sign: ${int} ${min}m ${milliSec}ms" }
    }
    fun milliSec() = value

    companion object{
        fun fromDecimal(v: Int) = AstronomicalUnit(v * (60 * 60 * 1000L))
        fun fromDecimal(v: Double) = AstronomicalUnit(v * (60 * 60 * 1000L))
        fun fromMilliSec(v: Long) = AstronomicalUnit(v)
    }

    private fun toDeg(): Degrees {
        return Degrees(value)
    }

    internal fun toUnit(): AstronomicalUnit {
        return AstronomicalUnit(value)
    }

    internal fun correctFor(maxValue: Long): Long {
        var h = value
        while (h !in 0..maxValue) {
            when {
                h < 0 -> h += maxValue
                h >= maxValue -> h -= maxValue
            }
        }
        return h
    }

    internal open fun averageStartEnd(end: Degrees): Degrees {
        val start = toDeg()
        val div = (end - start).correct360()

        val res = start + div / 2
        return res.correct360()
    }

    internal open fun averageCircle(v: Degrees): Degrees {
        val x = toDeg()
        val div = (x - v).absD()
        return if (div > 180.deg()) {
            when {
                x > v -> {
                    val toMax = Degrees(Degrees.DEGREES_MAX_VALUE) - x
                    (v + toMax) / 2
                }
                x < v -> {
                    val toMax = Degrees(Degrees.DEGREES_MAX_VALUE) - v
                    (x + toMax) / 2
                }
                else -> throw Exception("invalid")
            }
        } else {
            (x + v) / 2
        }

        /*
        val d1 = x.toDecimal()
        val d2 = v.toDecimal()
        val r1 = d1 * (PI / 180)
        val r2 = d2 * (PI / 180)
        val s1 = sin(r1)
        val s2 = sin(r2)
        val p1 = sin(95 * (PI / 180.0))
        val p2 = sin(85 * (PI / 180.0))
        return (Degrees.aSin((p1 + p2) / 2))
         */
    }

    fun abs(): Long {
        return abs(value)
    }

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
    fun toString(pattern: String): String {
        val DMMs: DMMs by lazy {
            toDMMs()
        }
        val deci: Double by lazy {
            toDecimal()
        }

        fun int() = deci.toInt()
        fun frac() = (deci - int()).toString().split('.')[1]

        //val match = "DHMSZ"
        val arr = pattern.toCharArray()
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

        return final.joinToString(separator = "")
    }

    /**
     * int, min, milliSec
     */
    internal fun toDMMs(): DMMs {
        var deci = toDecimal()
        val sign = deci.sign
        deci = abs(deci)
        val int = deci.toInt()
        val minSec = (deci - int) * 60
        val min = minSec.toInt()
        val milliSec = ((minSec - min) * 60 * 1000).toInt()
        return DMMs(sign, int, min, milliSec)
    }

    internal fun compare() = toDMMs().run { listOf(sign, int, min, milliSec / 1000) }

    fun toDecimal() = value / (1000 * 60 * 60).toDouble()
    fun toDecimalDay() = value / (24 * 1000 * 60 * 60).toDouble()
}