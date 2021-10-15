package com.example.lib.intern.coorSystems

import com.example.lib.intern.timeSystems.SiderealTime
import com.example.lib.intern.units.Degrees

data class HorizonSys(val azimuth: Degrees, val altitude: Degrees): CoorSystems(azimuth, altitude){
    override fun toString(): String {
        return super.toString()
    }
    internal fun toEquatorialSys(lat: Degrees, ST: SiderealTime): EquatorialSys {
        val declination = run {
            val t1 = altitude.sin() * lat.sin()
            val t2 = altitude.cos() * lat.cos() * azimuth.cos()
            Degrees.aSin(t1 + t2)
        }
        var hA = run {
            val o = altitude.sin() - (lat.sin() * declination.sin())
            val u = lat.cos() * declination.cos()
            Degrees.aCos(o / u)
        }
        if(azimuth.sin() > 0) {
            hA = Degrees.fromDecimal(360) - azimuth
        }
        val rightAscension = (ST - hA.toHours())
        return EquatorialSys(rightAscension, declination)
    }
}