package com.example.lib.port

import com.example.lib.intern.units.Degrees

/**
 * \[latitude] = Degrees
 *
 * \[longitude] = Degrees
 *
 * \[altitude] = Meters
 */
data class Observer(val latitude: Double, val longitude: Double, val altitude: Int){
    internal fun lat() = Degrees.fromDecimal(latitude)
    internal fun lon() = Degrees.fromDecimal(longitude)
}