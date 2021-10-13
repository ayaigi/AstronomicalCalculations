package com.example.astronomicalcalculations.intern.solarSystem

/*
enum class SolarMember(id: Int) {
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
internal class solar{
    private val id: Int
    constructor(id: Int) {
        this.id = id
    }
    constructor(v: SolarMember){
        this.id = v.ordinal
    }
    fun invoke(dateTime: LocalDateTime): SolarSystem {
        return when (id) {
            0 -> Sun(dateTime)
            1,2 -> Planet(id, dateTime)
            in 4..9 -> Planet(id, dateTime)
            3 -> Moon(dateTime)
            else -> throw Exception("invalid: $id")
        }
    }
}

 */