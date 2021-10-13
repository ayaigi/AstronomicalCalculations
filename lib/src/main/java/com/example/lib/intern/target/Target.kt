package com.example.astronomicalcalculations.intern.target

import com.example.astronomicalcalculations.intern.coorSystems.CoorSystems
import com.example.astronomicalcalculations.intern.coorSystems.EquatorialSys
import com.example.astronomicalcalculations.intern.units.Degrees
import java.time.LocalDateTime

internal interface Target {
    val dateTime: LocalDateTime

    val position : CoorSystems

    fun riseAndSet(lat: Degrees, lon: Degrees, altitude: Double): EquatorialSys.riseAndSet

}