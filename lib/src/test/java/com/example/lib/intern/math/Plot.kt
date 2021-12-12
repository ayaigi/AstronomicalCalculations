package com.example.lib.intern.math

import android.util.Log
import com.example.lib.intern.coorSystems.HorizonSys
import com.example.lib.intern.target.SolarSystemTarget
import com.example.lib.intern.timeSystems.SiderealTime
import com.example.lib.intern.units.Hours
import com.example.lib.intern.units.blueprint.AstronomicalUnit
import com.example.lib.port.Astronomy
import com.example.vectors.degToRad
import com.example.vectors.radToDeg
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*
import kotlin.math.sin

private fun main() {
    val astro = Astronomy(
        OffsetDateTime.of(2020, 6, 15, 12, 0, 0, 0, ZoneOffset.UTC),
        AstronomicalUnit.fromDecimal(50),
        AstronomicalUnit.fromDecimal(0),
        0
    )
    val res = astro.calc(SolarSystemTarget.SUN)
    val T_eq = res._positionEquatorialSys
    val date = res.OffsetDateTime.run {
        LocalDate.of(year, month, dayOfMonth)
    }
    val lat = res.Observer.lat()
    //var temp_Time: Hours = Hours.fromDecimal(0)
    var temp_SiderealTime: SiderealTime
    var temp_Offset: OffsetDateTime =
        OffsetDateTime.of(date, LocalTime.ofSecondOfDay(0), ZoneOffset.UTC)
    var temp_Hori: HorizonSys
    plotStart()
    for (i in 0 until (72 * 6)) {
        temp_Offset = temp_Offset.plusMinutes(10L)
        temp_SiderealTime = SiderealTime.fromOffsetDateTime(temp_Offset, res.Observer.lon())
        temp_Hori = T_eq.toHorizonSys(lat, temp_SiderealTime)
        logPlot(temp_Hori, i)
    }
}

private val convert = true

private fun plotStart() {
    val me1: String = if (convert) "Time;Altitude;Azimuth;Gamma;Delta"
    else "Time,Altitude,Azimuth"

    val me2 = "N;Degrees;Degrees;Degrees;Degrees"
    println(me1)
    println(me2)
}

private fun convert(v: HorizonSys): Pair<Float, Float> {
    return ConvertAngles(
        v.altitude.toDecimal().toFloat().degToRad(),
        v.azimuth.toDecimal().toFloat().degToRad()
    ).run {
        val gamma = this.Gamma
        val delta = this.Delta
        Pair(gamma, delta)
    }
}

private fun logPlot(v: HorizonSys, i: Int) {
    if (convert) {
        val (Gamma, Delta) = convert(v)
        val Altitude = v.altitude.toDecimal().toFloat()
        val Azimuth: Float = v.azimuth.sin().toFloat() * 50 //.toDecimal().toFloat()
        val list = listOf(Altitude, Azimuth, Gamma, Delta).map { "%.2f".format(it) }
        println("$i;${list[0]};${list[1]};${list[2]};${list[3]}")
    } else {
        val a = v.altitude.toDecimal().toFloat()
        val A = v.azimuth.toDecimal().toFloat()
        logPlot(Pair(a, A), i)
    }
}

private fun logPlot(v: Pair<Float, Float>, i: Int) {
    val a = "%.3f".format(Locale.ENGLISH, v.first)
    val A = "%.3f".format(Locale.ENGLISH, (v.second))
    log(Triple(i.toString(), a, A))
}

private fun log(v: Triple<String, String, String>) {
    val me = "${v.first},${v.second},${v.third}"
    println(me)
}
