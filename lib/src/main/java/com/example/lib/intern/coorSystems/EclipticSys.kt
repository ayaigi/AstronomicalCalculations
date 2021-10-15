package com.example.lib.intern.coorSystems

import com.example.lib.intern.timeSystems.julianDay
import com.example.lib.intern.units.Degrees
import java.time.LocalDateTime
import kotlin.math.pow

data class EclipticSys(val lambda: Degrees, val betta: Degrees): CoorSystems(lambda, betta) {
    override fun toString(): String {
        return super.toString()
    }
    internal companion object {
        fun epsilon(dateTime: LocalDateTime): Degrees {
            val t = (dateTime.julianDay() - 2415020) / 36525.0
            val delta = Degrees.fromDecimal((46.845 * t + 0.0059 * t.pow(2) - 0.00181 * t.pow(3)) / 3600.0)
            return Degrees.fromDecimal(23.452294) - delta
        }
    }
    internal fun toEquatorialSys(dateTime: LocalDateTime): EquatorialSys {
        val epsilon = epsilon(dateTime)
        val declination = run {
            val p1 = betta.sin() * epsilon.cos()
            val p2 = betta.cos() * epsilon.sin() * lambda.sin()
            Degrees.aSin(p1 + p2)
        }
        val rightAscension = run {
            val y = run {
                val p1 = lambda.sin() * epsilon.cos()
                val p2 = betta.tan() * epsilon.sin()
                p1 - p2
            }
            val x = lambda.cos()
            Degrees.rmvAmbiguity(y, x).toHours()
        }
        return EquatorialSys(rightAscension, declination)
    }
}