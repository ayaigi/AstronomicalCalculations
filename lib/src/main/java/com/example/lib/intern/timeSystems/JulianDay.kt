package com.example.astronomicalcalculations.intern.timeSystems

import com.example.astronomicalcalculations.intern.units.Hours
import java.time.LocalDateTime
import java.time.temporal.JulianFields

fun LocalDateTime.epochDay1970(): Double{
    return this.toLocalDate().toEpochDay() + Hours.fromLocalTime(this.toLocalTime()).toDecimalDay()
}
fun LocalDateTime.epochDay1980(): Double{
    return this.toLocalDate().toEpochDay() + Hours.fromLocalTime(this.toLocalTime()).toDecimalDay() - 3651
}
fun LocalDateTime.julianDay(): Double{
    return this.toLocalDate().getLong(JulianFields.JULIAN_DAY) + Hours.fromLocalTime(this.toLocalTime()).toDecimalDay()
}