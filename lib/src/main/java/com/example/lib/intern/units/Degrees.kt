package com.example.astronomicalcalculations.intern.units
import com.example.astronomicalcalculations.intern.units.blueprint.astrUnitInter
import com.example.astronomicalcalculations.intern.units.blueprint.astrUnit
import com.example.astronomicalcalculations.intern.units.blueprint.toLongExept
import java.lang.Exception
import kotlin.math.*

/**
 * value in milli Seconds
 */
internal class Degrees(override var value: Long) : astrUnit(value), astrUnitInter {
    private constructor(value: Double) : this(value.toLongExept())

    override fun toString(): String {
        return super.toString("D.H")
    }

    companion object {
        fun fromDecimal(v: Double) = Degrees(v * (60 * 60 * 1000))
        fun fromDecimal(v: Int) = Degrees(v * (60 * 60 * 1000).toDouble())
        fun aSin(v: Double) = fromDecimal(fromRadians(asin(v)))
        fun aCos(v: Double) = fromDecimal(fromRadians(acos(v)))
        fun aTan(v: Double) = fromDecimal(fromRadians(atan(v)))
        fun fromRadians(v: Double) = v * (180 / PI)
        fun DegFromRadians(v: Double) = fromDecimal(v * (180 / PI))
        fun fromTriple(v: Triple<Int, Int, Int>) = v.run { of(first, second, third) }
        fun of(degrees: Int, minute: Int, second: Int, millis: Int = 0, negative: Boolean = false): Degrees {
            val degrees = abs(degrees)
            val min = degrees * 60L + minute
            val sec = min * 60 + second
            val mil = sec * 1000 + millis
            return Degrees(mil) * if(negative) -1 else 1
        }
        const val DEGREES_MAX_VALUE = 360 * 60 * 60 * 1000L - 1
        fun rmvAmbiguity(y: Double, x: Double): Degrees {
            var deg = aTan(y / x).toDecimal()
            val Quadrant = when {
                (x >= 0 && y >= 0) -> 1
                (x < 0 && y >= 0) -> 2
                (x < 0 && y < 0) -> 3
                (x >= 0 && y < 0) -> 4
                else -> throw Exception("Error: Remove Ambiguity")
            }
            val WerteAddRemove = intArrayOf(0, 180, 360, -180, -360)
            val WertePruefung = intArrayOf(0, 90, 180, 270, 360)
            var temp: Double
            for(i in WerteAddRemove) {
                temp = deg + i
                if(temp > WertePruefung[Quadrant - 1] && temp < WertePruefung[Quadrant]){
                    return fromDecimal(temp)
                }
            }
            throw Exception("Error: Remove Ambiguity")
        }
    }
    fun abs(): Degrees {
        return Degrees(abs(this))
    }
    override fun averageCircle(v: Degrees) = super.averageCircle(v)
    fun average(v: Degrees): Degrees {
        return (v + this) / 2
    }

    fun correct360() = Degrees(correctFor(DEGREES_MAX_VALUE))

    fun sin() = kotlin.math.sin(toRadians())

    fun cos() = kotlin.math.cos(toRadians())

    fun tan() = kotlin.math.tan(toRadians())

    fun toHours() = Hours(div(15).value)

    fun toRadians() = toDecimal() * (PI / 180)

    operator fun plus(v: Degrees) = Degrees(value.plus(v.value))

    operator fun minus(v: Degrees) = Degrees(value.minus(v.value))

    operator fun plusAssign(v: Degrees) {
        Degrees(value.plus(v.value))
    }

    operator fun minusAssign(v: Degrees) {
        Degrees(value.minus(v.value))
    }

    operator fun times(v: Double) = Degrees(value.times(v))

    operator fun times(v: Int) = Degrees(value.times(v))

    operator fun div(v: Double) = Degrees(value.div(v))

    operator fun div(v: Int) = Degrees(value.div(v))

    operator fun dec() = Degrees(value.dec())

    operator fun inc() = Degrees(value.inc())

    operator fun compareTo(v: Degrees) = value.compareTo(v.value)

    operator fun unaryMinus() = Degrees(value.unaryMinus())
}
internal fun Double.deg() = Degrees.fromDecimal(this)
internal fun Int.deg() = Degrees.fromDecimal(this)