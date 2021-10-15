package com.example.lib.intern.timeSystems

import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.Hours
import java.time.*
import java.time.temporal.ChronoField
import kotlin.math.pow

internal class SiderealTime(value: Long): Hours(value) {
    constructor(value: Hours): this(value.value)
    companion object {
        fun fromOffsetDateTime(v: OffsetDateTime, lon: Degrees): SiderealTime {
            val gst = run {
                val T0 = run {
                    val D = v.dayOfYear
                    val B = ParaB(v.toLocalDate())
                    val p1 = D * 0.0657098
                    val T0 = p1 - B
                    T0
                }
                val T1 = Hours.fromLocalTime(v.toLocalTime()).times(1.002738)
                (T1 + fromDecimal(T0)).correct24()
            }
            val lst = (gst + lon.toHours()).correct24()
            return SiderealTime(lst)
        }
        private fun ParaB(date: LocalDate): Double {
            val date = LocalDate.of(date.year, 1, 1)
            val D1900 = LocalDate.of(1899, 12, 31)

            val S = date.getLong(ChronoField.EPOCH_DAY) - D1900.getLong(ChronoField.EPOCH_DAY) - 1.5
            val T = S / 36525
            val R = 6.6460656 + (2400.051262 * T) + (0.00002581 * T.pow(2.0))
            val U = R - (24 * (date.year - 1900))
            val B = 24 - U

            return B
        }
    }
    fun convertToLocalTime(date: LocalDate, lon: Degrees): OffsetTime {
        val gst = (this - lon.toHours()).correct24()
        val gmt = run {
            val T0 = (date.dayOfYear * 0.0657098) - ParaB(date)
            val T1 = (gst - fromDecimal(T0)).correct24() * 0.99727
            T1
        }
        return gmt.toLocalTime().atOffset(ZoneOffset.UTC)
    }
}