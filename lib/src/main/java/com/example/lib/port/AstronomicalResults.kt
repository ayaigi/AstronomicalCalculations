package com.example.lib.port

import com.example.lib.intern.constellation.Constellation
import com.example.lib.intern.coorSystems.EclipticSys
import com.example.lib.intern.coorSystems.HorizonSys
import com.example.lib.intern.solarSystem.SolarSystem
import com.example.lib.intern.coorSystems.EquatorialSys
import com.example.lib.intern.math.Distance
import com.example.lib.intern.target.TargetChoose
import com.example.lib.intern.target.idToClass
import com.example.lib.intern.timeSystems.SiderealTime
import java.time.OffsetDateTime
import java.time.OffsetTime

class AstronomicalResults internal constructor(
    targetId: TargetChoose,
    val OffsetDateTime: OffsetDateTime,
    val Observer: Observer
) {
    private val localDateTime = OffsetDateTime.toUTC()
    private val target = idToClass(targetId.id, localDateTime)
    private val siderealTime = SiderealTime.fromOffsetDateTime(OffsetDateTime, Observer.lon())

    /**
     * Rise, Set
     */
    private fun riseAndSet(): Pair<OffsetTime, OffsetTime> {
        val (rS, sS, _, _, _) = Observer.run{
            target.riseAndSet(lat(), lon(), altitude.toDouble())
        }
        val rL = rS.convertToLocalTime(localDateTime.toLocalDate(), Observer.lon())
        val sL = sS.convertToLocalTime(localDateTime.toLocalDate(), Observer.lon())
        return Pair(rL, sL)
    }

    private val positionEclipticSys: EclipticSys? by lazy {
        positionEclipticSys()
    }

    private fun positionEclipticSys(): EclipticSys? {
        return if (target is SolarSystem) {
            this.target.position
        } else {
            null
        }
    }

    private val positionEquatorialSys: EquatorialSys by lazy {
        positionEquatorialSys()
    }

    private fun positionEquatorialSys(): EquatorialSys {
        return when (target) {
            is SolarSystem -> positionEclipticSys!!.toEquatorialSys(localDateTime)
            is Constellation -> target.position
            else -> throw Exception("invalid: $target")
        }
    }

    private val positionHorizonSys: HorizonSys by lazy {
        positionHorizonSys()
    }

    private fun positionHorizonSys(): HorizonSys {
        return when (target) {
            is SolarSystem -> positionEquatorialSys.correctParallax(
                distance!!.toEarthRadii(),
                Observer.lat(),
                (siderealTime - positionEquatorialSys.rightAscension).toDegrees(),
                Observer.altitude.toDouble()
            ).toHorizonSys(Observer.lat(), siderealTime)
            is Constellation -> positionEquatorialSys.toHorizonSys(Observer.lat(), siderealTime)
            else -> throw Exception("invalid: $target")
        }
    }

    private val distance: Distance? by lazy {
        distance()
    }

    private fun distance(): Distance? {
        return when (target) {
            is SolarSystem -> target.distance
            is Constellation -> null
            else -> throw Exception("invalid: $target")
        }
    }

    fun phase(): Pair<Double, Boolean>? {
        return if (target is SolarSystem) {
            target.phase()
        } else null

    }

}