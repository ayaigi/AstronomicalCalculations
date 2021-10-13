package com.example.astronomicalcalculations.intern.solarSystem

import com.example.astronomicalcalculations.intern.coorSystems.EclipticSys
import com.example.astronomicalcalculations.intern.target.Target

internal interface SolarSystem : Target {

    override val position: EclipticSys

    val distance: Double

    fun phase(): Pair<Double, Boolean>
}