package com.example.lib.intern.coorSystems

import com.example.lib.intern.timeSystems.SiderealTime
import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.Hours
import com.example.lib.intern.units.deg
import com.example.lib.intern.units.hour
import java.time.LocalDateTime

data class EquatorialSys(val rightAscension: Hours, val declination: Degrees): CoorSystems(rightAscension, declination){
    override fun toString(): String {
        return super.toString()
    }
    internal fun toHorizonSys(lat: Degrees, ST: SiderealTime): HorizonSys {
        val hA = (ST - rightAscension).toDegrees()
        val altitude = run {
            val t1 = declination.sin() * lat.sin()
            val t2 = declination.cos() * lat.cos() * hA.cos()
            Degrees.aSin(t1 + t2)
        }
        var azimuth = run {
            val o = declination.sin() - (lat.sin() * altitude.sin())
            val u = lat.cos() * altitude.cos()
            Degrees.aCos(o / u)
        }
        if(hA.sin() > 0) {
            azimuth = Degrees.fromDecimal(360) - azimuth
        }
        return HorizonSys(altitude, azimuth)
    }
    internal fun toEclipticSys(dateTime: LocalDateTime): EclipticSys {
        val rightAscension = rightAscension.toDegrees()
        val epsilon = EclipticSys.epsilon(dateTime)

        val Betta = run {
            val p1 = declination.sin() * epsilon.cos()
            val p2 = declination.cos() * epsilon.sin() * rightAscension.sin()
            Degrees.aSin(p1 - p2)
        }
        val Lambda = run {
            val y = run {
                val p1 = rightAscension.sin() * epsilon.cos()
                val p2 = declination.tan() * epsilon.sin()
                p1 + p2
            }
            val x = rightAscension.cos()
            Degrees.rmvAmbiguity(y, x)
        }
        return EclipticSys(Betta, Lambda)
    }
    internal fun riseAndSet(lat: Degrees, lon: Degrees): riseAndSet {
        val rightAscension = rightAscension.toDegrees()

        val Ar = run {
            val y = declination.sin()
            val x = lat.cos()
            Degrees.aCos(y / x).correct360()
        }
        val As = (360.deg() - Ar).correct360()

        val hA = run {
            val p1 = lat.tan() * declination.tan() * -1
            Degrees.aCos(p1).toHours()
        }

        val STr = SiderealTime((24.hour() + rightAscension.toHours() - hA).correct24())
        val STs = SiderealTime((rightAscension.toHours() + hA).correct24())

        return riseAndSet(STr, STs, Ar, As, hA)
    }
    internal data class riseAndSet(val STr: SiderealTime, val STs: SiderealTime, val Ar: Degrees, val As: Degrees, val hA: Hours) {
        fun toList() = listOf(STr, STs, Ar, As, hA)
    }
    internal fun correctParallax(parallax: Degrees, lat: Degrees, hourAngle: Degrees, altitude: Double): EquatorialSys {
        val r = (1 / parallax.sin())
        return correctParallax(r, lat, hourAngle, altitude)
    }

    /**
     * r in Earth-radii
     */
    internal fun correctParallax(r: Double, lat: Degrees, hourAngle: Degrees, altitude: Double): EquatorialSys {
        val rightAscension = rightAscension.toDegrees()

        val (cos, sin) = run {
            val u = Degrees.aTan(lat.tan() * 0.996647)
            val h = altitude / 6378140
            val cos = u.cos() + lat.cos() * h
            val sin = u.sin() * 0.996647 + lat.sin() * h
            Pair(cos, sin)
        }

        val delta = run {
            val p1 = cos * hourAngle.sin()
            val p2 = declination.cos() * r
            val p3 = cos * hourAngle.cos()
            Degrees.aTan(p1 / (p2 - p3))
        }
        val hA2 = hourAngle + delta
        val rightAscension2 = rightAscension - delta
        val declination2 = run {
            val sinDecli = declination.sin()
            val y = r * sinDecli - sin
            val x = r * declination.cos() * hourAngle.cos() - cos
            val p1 = y / x
            Degrees.aTan(hA2.cos() * (y / x))
        }
        return EquatorialSys(rightAscension2.toHours(), declination2)
    }
}