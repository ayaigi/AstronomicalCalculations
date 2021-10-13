package com.example.astronomicalcalculations.intern.solarSystem

import com.example.astronomicalcalculations.intern.coorSystems.EclipticSys
import com.example.astronomicalcalculations.intern.coorSystems.EquatorialSys
import com.example.astronomicalcalculations.intern.timeSystems.SiderealTime
import com.example.astronomicalcalculations.intern.timeSystems.epochDay1980
import com.example.astronomicalcalculations.intern.timeSystems.julianDay
import com.example.astronomicalcalculations.intern.units.Degrees
import com.example.astronomicalcalculations.intern.units.Hours
import com.example.astronomicalcalculations.intern.units.deg
import com.example.astronomicalcalculations.intern.units.hour
import java.time.LocalDateTime
import kotlin.math.pow

internal class Planet : SolarSystem {
    val planet: Planets
    override val dateTime: LocalDateTime

    override val position: EclipticSys by lazy {
        position()
    }
    override val distance: Double by lazy {
        distance()
    }
    private val posiValues: planetValues by lazy {
        posiValues()
    }

    override fun phase(): Pair<Double, Boolean> {
        val F0 = run {
            val lp = posiValues.lp
            val lambda = position.lambda
            val d = (lambda - lp)
            0.5 * (1 + d.cos())
        }
        val F1 = run {
            val lp = posiValues.lp
            val lambda = Planet(planet, dateTime.plusDays(2L)).position.lambda
            val d = (lambda - lp)
            0.5 * (1 + d.cos())
        }
        return Pair(F0, F0 > F1)
    }

    private fun position(): EclipticSys {
        val (rp, re, lp, le) = posiValues

        val psi = run {
            val p1 = (lp - planet.longAscendingNodeGOmega).sin()
            val p2 = planet.inclinationI.sin()
            Degrees.aSin(p1 * p2)
        }
        val l2 = planet.run {
            val y = run {
                val p1 = (lp - longAscendingNodeGOmega).sin()
                val p2 = inclinationI.cos()
                p1 * p2
            }
            val x = (lp - longAscendingNodeGOmega).cos()
            val L2 = Degrees.rmvAmbiguity(y, x) + longAscendingNodeGOmega
            L2
        }
        val r2 = psi.cos() * rp

        val Lambda = if (planet.innerOuter) {
            val A = run {
                val y = (le - l2).sin() * r2
                val x = re - r2 * (le - l2).cos()
                Degrees.aTan(y / x)
            }
            le + Degrees.fromDecimal(180) + A
        } else {
            val A = run {
                val y = (l2 - le).sin() * re
                val x = r2 - (l2 - le).cos() * re
                Degrees.aTan(y / x)
            }
            A + l2
        }
        val Betta = run {
            val y = run {
                val p1 = psi.tan() * r2
                val p2 = (Lambda - l2).sin()
                p1 * p2
            }
            val x = (l2 - le).sin() * re
            Degrees.aTan(y / x)
        }
        return EclipticSys(Lambda, Betta)
    }

    private fun posiValues(): planetValues {
        val D = dateTime.epochDay1980()
        val vp = calcV(D)
        var lp = (vp + planet.longPerihelionOmega).correct360()
        if (planet.id in 5..6) {
            val T = (dateTime.julianDay() - 2415020) / 36525
            val A = T / 5 + 0.1
            val P = Degrees.fromDecimal(237.47555 + 3034.9061 * T)
            val Q = Degrees.fromDecimal(265.91650 + 1222.1139 * T)
            val V = Q * 5 - P * 2
            val B = Q - P
            val dL: Degrees = if (planet.id == 5) {
                val t1 = Degrees.fromDecimal(0.3314 - 0.0103 * A) * V.sin()
                val t2 = Degrees.fromDecimal(0.0644 * A * V.cos())
                t1 - t2
            } else {
                val t1 = V.cos() * (0.1609 * A - 0.0105)
                val t2 = V.sin() * (0.0182 * A - 0.8142)
                val t3 = B.sin() * 0.1488 - 0.0408 * (B * 2).sin()
                val t4 = B.sin() * 0.0856 * Q.cos()
                val t5 = B.cos() * 0.0813 * Q.sin()
                Degrees.fromDecimal(t1 + t2 - t3 + t4 + t5)
            }
            lp = lp + dL
        }

        val rp = calcR(vp)

        val earth = getPlanet(3)
        val ve = calcV(D, earth)
        val le = (ve + earth.longPerihelionOmega).correct360()
        val re = calcR(ve, earth)
        return planetValues(rp, re, lp, le)
    }

    private data class planetValues(val rp: Double, val re: Double, val lp: Degrees, val le: Degrees)

    private fun calcV(D: Double, planet: Planets = this.planet): Degrees {
        return planet.run {
            val np = Degrees.fromDecimal((360 / 365.2422) * (D / periodTp)).correct360()
            val mp =
                np + longEpsilon - longPerihelionOmega
            val ep = Sun.routineR2(mp, eccentricityE)
            ep.second
        }
    }

    private fun calcR(v: Degrees, planet: Planets = this.planet): Double {
        planet.run {
            val y = semiMajorAxisAAU * (1 - eccentricityE.pow(2))
            val x = 1 + eccentricityE * v.cos()
            return y / x
        }
    }

    private fun distance(): Double {
        val (r, R, l, L) = posiValues
        val p2 = R.pow(2) + r.pow(2) - (2 * R * r * (l - L).cos())
        return p2.pow(0.5)
    }

    override fun riseAndSet(lat: Degrees, lon: Degrees, altitude: Double): EquatorialSys.riseAndSet {
        val posi0 = run {
            val dateTime = dateTime.toLocalDate().atTime(0,0)
            Planet(planet, dateTime).position.toEquatorialSys(dateTime)
        }
        val posi24 = run {
            val dateTime = dateTime.toLocalDate().plusDays(1L).atTime(0,0)
            Planet(planet, dateTime.plusDays(1L)).position.toEquatorialSys(dateTime)
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

    constructor(planet: Planets, dateTime: LocalDateTime) {
        this.planet = planet
        this.dateTime = dateTime
    }

    constructor(planet: Int, dateTime: LocalDateTime) {
        this.planet = getPlanet(planet)
        this.dateTime = dateTime
    }
}