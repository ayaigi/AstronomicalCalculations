package com.example.lib.intern.units
import com.example.lib.intern.units.blueprint.astrUnitInter
import com.example.lib.intern.units.blueprint.AstronomicalUnit
import com.example.lib.intern.units.blueprint.UnitFormat
import com.example.lib.intern.units.blueprint.toLongExept
import java.lang.Exception
import kotlin.math.*

/**
 * value in milli Seconds
 */
class Degrees(override var value: Long) : AstronomicalUnit(value), astrUnitInter {
    private constructor(value: Double) : this(value.toLongExept())

    override fun toString(): String {
        return super.toString(UnitFormat.pattern("D.H"))
    }

    internal companion object {
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
    fun absD(): Degrees {
        return Degrees(super.abs())
    }
    internal override fun averageCircle(v: Degrees) = super.averageCircle(v)
    internal fun average(v: Degrees): Degrees {
        return (v + this) / 2
    }

    internal fun correct360() = Degrees(correctFor(DEGREES_MAX_VALUE))

    internal fun sin() = kotlin.math.sin(toRadians())

    internal fun cos() = kotlin.math.cos(toRadians())

    internal fun tan() = kotlin.math.tan(toRadians())

    internal fun toHours() = Hours(div(15).value)

    internal fun toRadians() = toDecimal() * (PI / 180)

    internal operator fun plus(v: Degrees) = Degrees(value.plus(v.value))

    internal operator fun minus(v: Degrees) = Degrees(value.minus(v.value))

    internal operator fun plusAssign(v: Degrees) {
        Degrees(value.plus(v.value))
    }

    internal operator fun minusAssign(v: Degrees) {
        Degrees(value.minus(v.value))
    }

    internal operator fun times(v: Double) = Degrees(value.times(v))

    internal operator fun times(v: Int) = Degrees(value.times(v))

    internal operator fun div(v: Double) = Degrees(value.div(v))

    internal operator fun div(v: Int) = Degrees(value.div(v))

    internal operator fun dec() = Degrees(value.dec())

    internal operator fun inc() = Degrees(value.inc())

    internal operator fun compareTo(v: Degrees) = value.compareTo(v.value)

    internal operator fun unaryMinus() = Degrees(value.unaryMinus())
}
internal fun Double.deg() = Degrees.fromDecimal(this)
internal fun Int.deg() = Degrees.fromDecimal(this)