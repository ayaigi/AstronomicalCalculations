package com.example.lib.intern.coorSystems

import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.Hours
import com.example.lib.intern.units.blueprint.AstronomicalUnit
import com.example.lib.intern.units.blueprint.UnitFormat

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
        val lat = "${lat.toDecimal()}; ${lat.toString(UnitFormat("D° Mm Ss", UnitFormat.type_Latitude))}"
        val lon = "${lon.toDecimal()}; ${lon.toString(UnitFormat("D° Mm Ss", UnitFormat.type_Longitude))}"
        return "lat: $lat \nlon: $lon"
    }
    internal fun compare(): List<Int> {
        return lon.compare() + lat.compare()
    }
}