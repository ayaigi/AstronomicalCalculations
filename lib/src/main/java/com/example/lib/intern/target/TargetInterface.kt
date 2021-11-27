package com.example.lib.intern.target

import com.example.lib.intern.coorSystems.CoorSystems
import com.example.lib.intern.coorSystems.EquatorialSys
import com.example.lib.intern.units.Degrees
import java.time.LocalDateTime

internal interface TargetInterface {
    val dateTime: LocalDateTime

    val position : CoorSystems

    fun riseAndSet(lat: Degrees, lon: Degrees, altitude: Double): EquatorialSys.riseAndSet

}
object SolarSystemTarget {
    val SUN = Target(0)
    val MERCURY = Target(1)
    val VENUS = Target(2)
    val MOON = Target(3)
    val MARS = Target(4)
    val JUPITER = Target(5)
    val SATURN = Target(6)
    val URANUS = Target(7)
    val NEPTUNE = Target(8)
    val PLUTO = Target(9)
}

data class Target(val id: Int) {
    companion object {
        fun fromID(v: Int): Target = Target(v)
    }
}

/*
enum class SolarSystemTarget(override val id: Int): TargetChoose{
    SUN(0),
    MERCURY(1),
    VENUS(2),
    MOON(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8),
    PLUTO(9)
}
interface TargetChoose {
    companion object{
        fun fromID(v: Int): TargetChoose = Target(v)
    }
    val id: Int

    override operator fun equals(other: Any?): Boolean
}
private class Target(override val id: Int) : TargetChoose
 */