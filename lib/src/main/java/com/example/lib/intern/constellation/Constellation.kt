package com.example.astronomicalcalculations.intern.constellation

import com.example.astronomicalcalculations.intern.target.Target
import com.example.astronomicalcalculations.intern.coorSystems.EquatorialSys
import com.example.astronomicalcalculations.intern.units.Degrees
import java.time.LocalDateTime

internal class Constellation(id: Int, override val dateTime: LocalDateTime) : Target {
    val value = idToConst(id)
    private val rightAscensionMedia = value.rightMin.averageStartEnd(value.rightMax)
    private val declinationMedia = value.decliMin.averageStartEnd(value.decliMax)

    override val position: EquatorialSys by lazy {
        position()
    }
    private fun position(): EquatorialSys {
        return EquatorialSys(rightAscensionMedia, declinationMedia)
    }

    override fun riseAndSet(
        lat: Degrees,
        lon: Degrees,
        altitude: Double
    ): EquatorialSys.riseAndSet {
        TODO("Not yet implemented")
    }
}