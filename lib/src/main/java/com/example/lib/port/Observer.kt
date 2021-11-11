package com.example.lib.port

import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.blueprint.AstronomicalUnit

/**
 * latitude = Degrees
 *
 * longitude = Degrees
 *
 * altitude = Meters
 */
data class Observer(val latitude: Double, val longitude: Double, val altitude: Int){
    internal fun lat() = Degrees.fromDecimal(latitude)
    internal fun lon() = Degrees.fromDecimal(longitude)
    companion object{
        operator fun invoke(latitude: AstronomicalUnit, longitude: AstronomicalUnit, altitude: Int) = Observer(latitude.toDecimal(), longitude.toDecimal(), altitude)
        operator fun invoke(latitude: AstronomicalUnit, longitude: AstronomicalUnit, altitude: Short) = Observer(latitude.toDecimal(), longitude.toDecimal(), altitude.toInt())
    }
}