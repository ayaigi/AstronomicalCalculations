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
import com.example.lib.intern.units.blueprint.AstronomicalUnit
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
    fun riseAndSet(): Pair<OffsetTime, OffsetTime> {
        val (rS, sS, _, _, _) = Observer.run {
            target.riseAndSet(lat(), lon(), altitude.toDouble())
        }
        val rL = rS.convertToLocalTime(localDateTime.toLocalDate(), Observer.lon())
        val sL = sS.convertToLocalTime(localDateTime.toLocalDate(), Observer.lon())
        return Pair(rL, sL)
    }

    /**
     * Betta: Degrees
     *
     * Lambda: Degrees
     */
    fun eclipticPosition(): Pair<AstronomicalUnit, AstronomicalUnit>? {
        return _positionEclipticSys?.run {
            Pair(betta.toUnit(), lambda.toUnit())
        } //Pair(null, null)
    }

    private val _positionEclipticSys: EclipticSys? by lazy {
        _positionEclipticSys()
    }

    private fun _positionEclipticSys(): EclipticSys? {
        return if (target is SolarSystem) {
            this.target.position
        } else {
            null
        }
    }

    /**
     * RightAscension: Hours
     *
     * Declination: Degrees
     */
    fun equatorialPosition(): Pair<AstronomicalUnit, AstronomicalUnit> {
        return _positionEquatorialSys.run {
            Pair(rightAscension.toUnit(), declination.toUnit())
        }
    }

    private val _positionEquatorialSys: EquatorialSys by lazy {
        _positionEquatorialSys()
    }

    private fun _positionEquatorialSys(): EquatorialSys {
        return when (target) {
            is SolarSystem -> _positionEclipticSys!!.toEquatorialSys(localDateTime)
            is Constellation -> target.position
            else -> throw Exception("invalid: $target")
        }
    }

    /**
     * Azimuth: Degrees
     *
     * Altitude: Degrees
     */
    fun horizonPosition(): Pair<AstronomicalUnit, AstronomicalUnit> {
        return _positionHorizonSys.run {
            Pair(azimuth.toUnit(), altitude.toUnit())
        }
    }

    private val _positionHorizonSys: HorizonSys by lazy {
        _positionHorizonSys()
    }

    private fun _positionHorizonSys(): HorizonSys {
        return when (target) {
            is SolarSystem -> _positionEquatorialSys.correctParallax(
                _distance!!.toEarthRadii().toDouble(),
                Observer.lat(),
                (siderealTime - _positionEquatorialSys.rightAscension).toDegrees(),
                Observer.altitude.toDouble()
            ).toHorizonSys(Observer.lat(), siderealTime)
            is Constellation -> _positionEquatorialSys.toHorizonSys(Observer.lat(), siderealTime)
            else -> throw Exception("invalid: $target")
        }
    }

    fun distance() = _distance

    private val _distance: Distance? by lazy {
        _distance()
    }

    private fun _distance(): Distance? {
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