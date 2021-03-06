package com.example.lib.port

import com.example.lib.intern.constellation.Constellation
import com.example.lib.intern.coorSystems.EclipticSys
import com.example.lib.intern.coorSystems.EquatorialSys
import com.example.lib.intern.coorSystems.HorizonSys
import com.example.lib.intern.coorSystems.Observer
import com.example.lib.intern.solarSystem.SolarSystem
import com.example.lib.intern.target.idToClass
import com.example.lib.intern.timeSystems.SiderealTime as ST
import java.time.OffsetDateTime

@Deprecated("use AstronomicalResults", level = DeprecationLevel.WARNING)
class Calculations internal constructor(id: Int, OffsetDateTime: OffsetDateTime, private val Observer: Observer){

    private val dateTime = OffsetDateTime.toLocalDateTime()
    private val target = idToClass(id, dateTime)

    /**
     * Azimuth, Altitude
     */
    val position: Pair<simpleAstrUnit, simpleAstrUnit> by lazy {
        val (A, a) = horizonSys
        val A2 = simpleAstrUnit(A.value)
        val a2 = simpleAstrUnit(a.value)
        Pair(A2, a2)
    }

    fun phase(): Pair<Double, Boolean>? {
        return if(target is SolarSystem){
            target.phase()
        }else null

    }



    private val distance: Double? by lazy {
        distance()
    }
    fun distance(): Double? {
        return when(target) {
            is SolarSystem -> target.distance.toKm().toDouble()
            is Constellation -> null
            else -> throw Exception("invalid: $target")
        }
    }

    /**
     * Rise, Set
     */
    val riseAndSet: Pair<simpleAstrUnit, simpleAstrUnit> by lazy {
        val (r, s, _, _, _) = this.target.riseAndSet(Observer.lat, Observer.lon, Observer.alt.toDouble())
        val R = simpleAstrUnit(r.value)
        val S = simpleAstrUnit(s.value)
        Pair(R, S)
    }

    private val eclipticSys: EclipticSys? by lazy {
        eclipticSys()
    }
    private val equatorialSys: EquatorialSys by lazy {
        equatorialSys()
    }
    private val siderealTime: ST by lazy {
        com.example.lib.intern.timeSystems.SiderealTime.fromOffsetDateTime(OffsetDateTime, Observer.lon)
    }
    private val horizonSys: HorizonSys by lazy {
        horizonSys()
    }
    private fun eclipticSys(): EclipticSys? {
        return if(target is SolarSystem) {
            this.target.position
        }else{
            null
        }
    }
    private fun equatorialSys(): EquatorialSys {
        return when(target) {
            is SolarSystem -> eclipticSys!!.toEquatorialSys(dateTime)
            is Constellation -> target.position
            else -> throw Exception("invalid: $target")
        }
    }
    private fun horizonSys(): HorizonSys {
        return when(target) {
            is SolarSystem -> equatorialSys.correctParallax(distance!!, Observer.lat, (siderealTime - equatorialSys.rightAscension).toDegrees(), Observer.alt.toDouble()).toHorizonSys(Observer.lat, siderealTime)
            is Constellation -> equatorialSys.toHorizonSys(Observer.lat, siderealTime)
            else -> throw Exception("invalid: $target")
        }
    }
}