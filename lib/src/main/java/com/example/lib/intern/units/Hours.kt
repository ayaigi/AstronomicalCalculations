package com.example.lib.intern.units

import com.example.lib.intern.units.blueprint.astrUnitInter
import com.example.lib.intern.units.blueprint.AstronomicalUnit
import com.example.lib.intern.units.blueprint.toLongExept
import java.time.LocalTime
import kotlin.math.abs

/**
 * value in milli Seconds
 */
open class Hours(override var value: Long) : AstronomicalUnit(value), astrUnitInter {
    private constructor(value: Double) : this(value.toLongExept())

    internal companion object {
        private const val HOURS_MAX_VALUE = 24 * 60 * 60 * 1000L - 1
        fun fromLocalTime(v: LocalTime) = Hours(v.toNanoOfDay() / (10E5).toLong())  //v.run {of(hour, minute, second, (nano / 10E6).toInt())}
        fun of(hours: Int, minute: Int, second: Int, millis: Int = 0, negative: Boolean = false): Hours {
            val degrees = abs(hours)
            val min = degrees * 60L + minute
            val sec = min * 60 + second
            val mil = sec * 1000 + millis
            return Hours(mil) * if(negative) -1 else 1
        }
        fun fromDecimal(v: Double) = Hours(v * (60 * 60 * 1000))
        fun fromDecimal(v: Int) = Hours(v * (60 * 60 * 1000).toDouble())
        fun fromDecimal(v: Float) = Hours((v * (60 * 60 * 1000)).toDouble())
        fun fromSecond(v: Long) = Hours(v * 1000)
    }
    internal fun averageCircle(v: Hours) = (averageCircle(toDegrees())).toHours()
    internal fun averageStartEnd(v: Hours) = (averageStartEnd(toDegrees())).toHours()

    fun toLocalTime() : LocalTime{
        return LocalTime.ofNanoOfDay(value * (10E5).toLong())
    }

    internal fun average(v: Hours): Hours {
        return (v + this) / 2
    }

    override fun toString(): String {
        return super.toString()
    }

    internal  fun correct24() = Hours(correctFor(HOURS_MAX_VALUE))

    internal  fun toDegrees() = Degrees(times(15).value)

    internal operator fun plus(v: Hours) = Hours(value.plus(v.value))

    internal operator fun minus(v: Hours) = Hours(value.minus(v.value))

    internal operator fun plusAssign(v: Hours) {
        Hours(value.plus(v.value))
    }

    internal operator fun minusAssign(v: Hours) {
        Hours(value.minus(v.value))
    }

    internal operator fun times(v: Double) = Hours(value.times(v))

    internal operator fun times(v: Int) = Hours(value.times(v))

    internal operator fun div(v: Double) = Hours(value.div(v))

    internal operator fun div(v: Int) = Hours(value.div(v))

    internal operator fun dec() = Hours(value.dec())

    internal operator fun inc() = Hours(value.inc())

    internal operator fun compareTo(v: Hours) = value.compareTo(v.value)

    internal operator fun unaryMinus() = Hours(value.unaryMinus())
}
internal fun Double.hour() = Hours.fromDecimal(this)
internal fun Int.hour() = Hours.fromDecimal(this)