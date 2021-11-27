package com.example.lib.port

import com.example.lib.intern.target.Target
import com.example.lib.intern.units.blueprint.AstronomicalUnit
import java.time.OffsetDateTime

class Astronomy private constructor(val OffsetDateTime: OffsetDateTime, val Observer: Observer) {
    companion object {
        operator fun invoke(OffsetDateTime: OffsetDateTime, Observer: Observer) =
            Astronomy(OffsetDateTime, Observer)

        operator fun invoke(
            OffsetDateTime: OffsetDateTime,
            Latitude: AstronomicalUnit,
            Longitude: AstronomicalUnit,
            Altitude: Int
        ) = Astronomy(
            OffsetDateTime,
            Observer(Latitude.toDecimal(), Longitude.toDecimal(), Altitude)
        )
    }

    /**
     * use SolarSystemTarget or Companion by ID
     */
    fun calc(target: Target) = AstronomicalResults(target, OffsetDateTime, Observer)
}