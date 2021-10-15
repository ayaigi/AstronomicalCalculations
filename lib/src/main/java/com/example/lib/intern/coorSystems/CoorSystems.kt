package com.example.lib.intern.coorSystems

import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.Hours
import com.example.lib.intern.units.blueprint.AstronomicalUnit

open class CoorSystems {
    internal val lon: AstronomicalUnit
    internal val lat: AstronomicalUnit

    internal constructor(lon: Degrees, lat: Degrees) {
        this.lat = lat
        this.lon = lon
    }
    internal constructor(lon: Hours, lat: Degrees){
        this.lat = lat
        this.lon = lon
    }

    override fun toString(): String {
        return "lon: $lon, lat: $lat"
    }
    internal fun compareString(): String {
        val lat = "${lat.toDecimal()}; ${lat.toString("D° Mm Ss")}"
        val lon = "${lon.toDecimal()}; ${lon.toString("D° Mm Ss")}"
        return "lat: $lat \nlon: $lon"
    }
    internal fun compare(): List<Int> {
        return lon.compare() + lat.compare()
    }
}