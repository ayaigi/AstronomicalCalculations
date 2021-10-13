package com.example.astronomicalcalculations.intern.coorSystems

import com.example.astronomicalcalculations.intern.units.Degrees
import com.example.astronomicalcalculations.intern.units.Hours
import com.example.astronomicalcalculations.intern.units.blueprint.astrUnit

internal open class CoorSystems {
    val lon: astrUnit
    val lat: astrUnit

    constructor(lon: Degrees, lat: Degrees) {
        this.lat = lat
        this.lon = lon
    }
    constructor(lon: Hours, lat: Degrees){
        this.lat = lat
        this.lon = lon
    }

    override fun toString(): String {
        return "lon: $lon, lat: $lat"
    }
    fun compareString(): String {
        val lat = "${lat.toDecimal()}; ${lat.toString("D° Mm Ss")}"
        val lon = "${lon.toDecimal()}; ${lon.toString("D° Mm Ss")}"
        return "lat: $lat \nlon: $lon"
    }
    fun compare(): List<Int> {
        return lon.compare() + lat.compare()
    }
}