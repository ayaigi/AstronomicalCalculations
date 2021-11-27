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
enum class SolarSystemTarget(private val id: Int) {
    SUN(0),
    MERCURY(1),
    VENUS(2),
    MOON(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8),
    PLUTO(9);

    fun toT(): Target = Target(id)
}
interface TargetChoose {
    companion object{
        fun fromID(v: Int): TargetChoose = Target(v)
    }
    val id: Int
}
data class Target(override val id: Int) : TargetChoose

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