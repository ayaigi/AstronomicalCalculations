package com.example.astronomicalcalculations.intern.solarSystem

import com.example.astronomicalcalculations.intern.coorSystems.EclipticSys
import com.example.astronomicalcalculations.intern.coorSystems.EquatorialSys
import com.example.astronomicalcalculations.intern.timeSystems.SiderealTime
import com.example.astronomicalcalculations.intern.timeSystems.epochDay1980
import com.example.astronomicalcalculations.intern.units.Degrees
import com.example.astronomicalcalculations.intern.units.Hours
import com.example.astronomicalcalculations.intern.units.deg
import com.example.astronomicalcalculations.intern.units.hour
import java.time.LocalDateTime
import kotlin.math.*

internal class Sun(override val dateTime: LocalDateTime) : SolarSystem {

    companion object {
        val epsilonG = Degrees.fromDecimal(278.83354)
        val omegaG = Degrees.fromDecimal(282.596403)
        val rho = 0.016718
        /**in km*/
        val r0 = 1.495985 * 10.0.pow(8)
        val Theta0 = Degrees.fromDecimal(0.533128)

        /**
         * E, v
         */
        fun routineR2(M: Degrees, rho: Double): Pair<Degrees, Degrees> {
            val epsilon = 10E-6
            val M = M.toRadians()
            var E = M
            var decli = E - rho * sin(E) - M
            var delta: Double

            var counter = 0
            while (abs(decli) > epsilon) {
                decli = E - rho * sin(E) - M
                delta = decli / (1 - rho * cos(E))
                E -= delta
                counter++
            }
            //println("iterations: $counter")
            val v = atan((((1 + rho) / (1 - rho)).pow(0.5)) * tan(E / 2)) * 2
            return Pair(Degrees.DegFromRadians(E), Degrees.DegFromRadians(v))
        }
    }
    override val position: EclipticSys by lazy {
        position()
    }
    override val distance: Double by lazy {
        distance()
    }
    val posiValues: SunValues by lazy {
        posiValues()
    }

    private fun position(): EclipticSys {
        return EclipticSys(posiValues.Lambda, 0.0.deg())
    }

    private fun distance(): Double {
        return r0 / paraF
    }
    val angularSize: Degrees by lazy {
        angularSize()
    }
    private fun angularSize(): Degrees {
        return Theta0 * paraF
    }

    private val paraF: Double by lazy {
        paraF()
    }
    private fun paraF(): Double{
        val (_, v, _) = posiValues
        val y = 1 + rho * v.cos()
        val x = 1 - rho.pow(2)
        return y / x
    }

    override fun riseAndSet(lat: Degrees, lon: Degrees, altitude: Double): EquatorialSys.riseAndSet {
        val posi0 = run {
            val dateTime = dateTime.toLocalDate().atTime(0,0)
            Sun(dateTime).position.toEquatorialSys(dateTime)
        }
        val posi24 = run {
            val dateTime = dateTime.toLocalDate().plusDays(1L).atTime(0,0)
            Sun(dateTime.plusDays(1L)).position.toEquatorialSys(dateTime)
        }
        val riSe0 = posi0.riseAndSet(lat, lon)
        val riSe24 = posi24.riseAndSet(lat, lon)

        val AziR = riSe0.Ar.averageCircle(riSe24.Ar)
        val AziS = riSe0.As.averageCircle(riSe24.As)

        val tR = run {
            val p1 = riSe0.STr * 24.07
            val p2 = 24.07.hour() + riSe0.STr - riSe24.STr
            Hours(p1.value / p2.value)
        }
        val tS = run {
            val p1 = riSe0.STs * 24.07
            val p2 = 24.07.hour() + riSe0.STs - riSe24.STs
            Hours(p1.value / p2.value)
        }
        val delta = run {
            0.0.deg()
        }.toHours()
        val hA = riSe0.hA.averageCircle(riSe24.hA)
        val STr = SiderealTime(tS - delta)
        val STs = SiderealTime(tR - delta)
        return EquatorialSys.riseAndSet(STr, STs, AziR, AziS, hA)
    }

    override fun phase(): Pair<Double, Boolean> {
        return Pair(1.0, true)
    }

    /**
     * M, v, Lambda
     */
    private fun posiValues(): SunValues {
        val D = dateTime.epochDay1980()
        val N = Degrees.fromDecimal((360/365.2422) * D).correct360()
        val M = (N + epsilonG - omegaG).correct360()
        val R2 = routineR2(M, rho)
        val v = R2.second
        val Lambda = (v + omegaG).correct360()
        return SunValues(M, v, Lambda)
    }
    data class SunValues(val M: Degrees, val v: Degrees, val Lambda: Degrees)
}