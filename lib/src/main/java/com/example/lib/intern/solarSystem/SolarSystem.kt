package com.example.lib.intern.solarSystem

import com.example.lib.intern.coorSystems.EclipticSys
import com.example.lib.intern.math.Distance
import com.example.lib.intern.target.TargetInterface

internal interface SolarSystem : TargetInterface {

    override val position: EclipticSys

    val distance: Distance

    fun phase(): Pair<Double, Boolean>
}