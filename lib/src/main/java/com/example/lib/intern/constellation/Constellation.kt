package com.example.lib.intern.constellation

import com.example.astronomicalcalculations.intern.constellation.idToConst
import com.example.lib.intern.target.TargetInterface
import com.example.lib.intern.coorSystems.EquatorialSys
import com.example.lib.intern.units.Degrees
import java.time.LocalDateTime

internal class Constellation(id: Int, override val dateTime: LocalDateTime) : TargetInterface {
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