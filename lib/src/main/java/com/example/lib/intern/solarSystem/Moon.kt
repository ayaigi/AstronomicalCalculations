package com.example.lib.intern.solarSystem

import com.example.lib.intern.coorSystems.EclipticSys
import com.example.lib.intern.coorSystems.EquatorialSys
import com.example.lib.intern.timeSystems.SiderealTime
import com.example.lib.intern.timeSystems.epochDay1980
import com.example.lib.intern.units.Degrees
import com.example.lib.intern.math.Distance
import com.example.lib.intern.units.hour
import java.time.LocalDateTime
import kotlin.math.pow

internal class Moon (override val dateTime: LocalDateTime) : SolarSystem {
    companion object{
        /**Moon's mean longitude at the epoch - in Deg*/
        val l0 = Degrees.fromDecimal(64.975464)
        /**Mean longitude of the perigee at the epoch - in Deg*/
        val P0 = Degrees.fromDecimal(349.383063)
        /**Mean longitude of the node at the epoch - in Deg*/
        val N0 = Degrees.fromDecimal(151.950429)
        /**inclination of the Moon's Orbit - in Deg*/
        val i = Degrees.fromDecimal(5.145396)
        /**Eccentricity of the Moon's Orbit*/
        val e = 0.0549
        /**Semi-major axis of Moon's orbit - in km*/
        val a = 384401
        /**Moon's angular size at distance "a" from earth - in Deg*/
        val Theta0 = Degrees.fromDecimal(0.5181)
        /**Parallax at distance "a" from earth - in Deg*/
        val PI0 = Degrees.fromDecimal(0.9507)
    }

    override fun phase(): Pair<Double, Boolean> {
        val F0 = run{
            val la = Sun(dateTime).position.lambda
            val l = posiValues.l
            val D = l-la
            0.5 * (1 - D.cos())
        }
        val F1 = run{
            val la = Sun(dateTime.plusDays(1L)).position.lambda
            val l = posiValues.l
            val D = l-la
            0.5 * (1 - D.cos())
        }
        return Pair(F0, F0 > F1)
    }

    override val position: EclipticSys by lazy {
        position()
    }

    private val posiValues: MoonValues by lazy {
        posiValues()
    }

    override val distance: Distance by lazy {
        distance()
    }

    private fun position(): EclipticSys {
        val (_, _, l3, N2, _) = posiValues

        val Lambda = run {
            val y = run {
                val p1 = (l3 - N2).sin()
                val p2 = i.cos()
                p1 * p2
            }
            val x = (l3 - N2).cos()
            Degrees.rmvAmbiguity(y, x) + N2
        }
        val Betta = run {
            val p1 = (l3 - N2).sin()
            val p2 = i.sin()
            Degrees.aSin(p1 * p2)
        }
        return EclipticSys(Lambda, Betta)
    }
    private fun posiValues(): MoonValues {
        println("fun: positionValues")
        val sun = Sun(dateTime).posiValues
        val D = dateTime.epochDay1980()

        val l = (Degrees.fromDecimal(13.1763966) * D + l0).correct360()
        val Mm = (l - Degrees.fromDecimal(0.1114041) * D - P0).correct360()
        val N = (N0 - Degrees.fromDecimal(0.0529539) * D).correct360()
        val Ev = run {
            val C = l - sun.Lambda
            val p1 = C * 2 - Mm
            Degrees.fromDecimal(p1.sin() * 1.2739)
        }
        val Ae = Degrees.fromDecimal(sun.M.sin() * 0.1858)
        val A3 = Degrees.fromDecimal(sun.M.sin() * 0.37)
        val Mm2 = Mm + Ev - Ae - A3
        val Ec = Degrees.fromDecimal(Mm2.sin() * 6.2886)
        val A4 = Degrees.fromDecimal((Mm2 * 2).sin() * 0.214)
        val l2 = l + Ev + Ec - Ae + A4
        val V = run {
            val C = (l2 - sun.Lambda) * 2
            Degrees.fromDecimal(C.sin() * 0.6583)
        }
        val l3 = l2 + V
        val N2 = run {
            val p1 = Degrees.fromDecimal(sun.M.sin() * 0.16)
            N - p1
        }
        return MoonValues(Mm2, Ev, l3, N2, Ec)
    }
    data class MoonValues(val Mm: Degrees, val Ev: Degrees, val l: Degrees, val N: Degrees, val Ec: Degrees)

    override fun riseAndSet(lat: Degrees, lon: Degrees, altitude: Double): EquatorialSys.riseAndSet {
        val (riSe0, riSe24) = run {
            val r = distance.toEarthRadii()
            val date0 = dateTime.toLocalDate().atStartOfDay()
            val date24 = dateTime.toLocalDate().atTime(12,0)

            val posiEc0 = Moon(date0).position
            val posiEq0 = posiEc0.toEquatorialSys(date0)
            val posiEc24 = Moon(date24).position
            val posiEq24 = posiEc24.toEquatorialSys(date24)

            val H = Degrees.aCos(-(lat.tan()) * posiEq0.declination.average(posiEq24.declination).tan())

            val eqPa0 = posiEq0.correctParallax(r, lat, H, altitude)
            val eqPa24 = posiEq24.correctParallax(r, lat, H, altitude)

            val riSe0 = eqPa0.riseAndSet(lat, lon)
            val riSe24 = eqPa24.riseAndSet(lat, lon)

            Pair(riSe0, riSe24)
        }
        val rise = SiderealTime((riSe0.STr * 12.03) / (12.03.hour() + riSe0.STr - riSe24.STr).toDecimal())
        val set = SiderealTime((riSe0.STs * 12.03) / (12.03.hour() + riSe0.STs - riSe24.STs).toDecimal())
        val Ar = riSe0.Ar.average(riSe24.Ar)
        val As = riSe0.As.average(riSe24.As)
        val hA = riSe0.hA.average(riSe24.hA)

        return EquatorialSys.riseAndSet(rise, set, Ar, As, hA)
    }

    fun distanceInOrbit (): Double {
        return (distance.toKm() / a).toDouble()
    }
    /** in km */
    private fun distance(): Distance {
        val y = a * (1 - e.pow(2))
        val x = run {
            val (Mm, _, _, _, Ec) = posiValues()
            val p1 = Mm + Ec
            val p2 = p1.cos() * e
            1 + p2
        }
        return Distance.fromKm(y / x)
    }
}