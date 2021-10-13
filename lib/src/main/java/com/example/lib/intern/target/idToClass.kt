package com.example.astronomicalcalculations.intern.target

import com.example.astronomicalcalculations.intern.constellation.Constellation
import com.example.astronomicalcalculations.intern.solarSystem.SolarSystem
import com.example.astronomicalcalculations.intern.solarSystem.Moon
import com.example.astronomicalcalculations.intern.solarSystem.Planet
import com.example.astronomicalcalculations.intern.solarSystem.Sun
import java.time.LocalDateTime

internal fun idToClass(id: Int, dateTime: LocalDateTime): Target {
    return when (id) {
        in 0..9 -> solarInvoke(id, dateTime)
        in 101..188 -> Constellation(id, dateTime)
        else -> throw Exception("invalid: $id")
    }
}

private fun solarInvoke(id: Int, dateTime: LocalDateTime): SolarSystem {
    return when (id) {
        0 -> Sun(dateTime)
        1, 2 -> Planet(id, dateTime)
        in 4..9 -> Planet(id, dateTime)
        3 -> Moon(dateTime)
        else -> throw Exception("invalid: $id")
    }
}