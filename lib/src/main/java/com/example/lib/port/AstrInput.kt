package com.example.lib.port

import com.example.lib.intern.coorSystems.Observer
import com.example.lib.intern.units.Degrees
import com.example.lib.intern.units.Hours
import com.example.lib.intern.units.deg
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Deprecated("use 'Astronomy'-class")
class AstrInput private constructor(private val OffsetDateTime: OffsetDateTime, private val Observer: Observer) {

    fun calc(target: Int): Calculations {
        return Calculations(target, OffsetDateTime, Observer)
    }
    override fun toString(): String {
        return "${Observer}, DT($OffsetDateTime)"
    }

    companion object {
        fun invoke(
            dateTime: OffsetDateTime,
            lat: simpleAstrUnit,
            lon: simpleAstrUnit,
            alt: Short
        ): AstrInput {
            val observer = Observer(Degrees(lat.value()), Degrees(lon.value()), alt.toInt())
            return AstrInput(dateTime, observer)
        }

        /**
         * date: dd.MM.yyyy
         *
         * time: HH.hh || HH.mm.ss || hh..mm
         *
         * tz: -12 - 12
         *
         * lat: DDD.dd || DDD..mm
         *
         * lon: DDD.dd || DDD..mm
         */
        fun check(
            date: String,
            time: String,
            tz: String,
            lat: String,
            lon: String,
            alt: String
        ): AstrInput? {
            val date = dateCheck(date)
            val time = timeCheck(time)
            val tz = tzCheck(tz)
            val lat = latCheck(lat)
            val lon = lonCheck(lon)
            val alt = altCheck(alt)
            return if (!(date.isNull() || time.isNull() || tz.isNull() || lat.isNull() || lon.isNull() || alt.isNull())) {
                val offsetDateTime = OffsetDateTime.of(date, time, tz)
                val observer = Observer(lat!!, lon!!, alt!!)
                AstrInput(offsetDateTime, observer)
            } else {
                null
            }
        }

        private fun Any?.isNull() = this == null

        private fun dateCheck(v: String): LocalDate? {
            return try {
                val arr = v.split('.')
                val d = if(arr[0].length == 1) "d" else "dd"
                val M = if(arr[1].length == 1) "M" else "MM"
                val y = if(arr[2].length == 2) "yy" else "yyyy"
                LocalDate.parse(v, DateTimeFormatter.ofPattern("$d.$M.$y"))
            } catch (e: Exception) {
                null
            }
        }

        private fun timeCheck(v: String): LocalTime? {
            return try {
                val list = v.split('.')
                return if (list.size == 3) {
                    val pattern2 = if(list[1].isEmpty()) {
                        val H = if(list[0].length == 1) "H" else "HH"
                        val m = if(list[2].length == 1) "m" else "mm"
                        "$H..$m"
                    }else{
                        val H = if(list[0].length == 1) "H" else "HH"
                        val m = if(list[1].length == 1) "m" else "mm"
                        val s = if(list[2].length == 1) "s" else "ss"
                        "$H.$m.$s"
                    }
                    //val pattern = if (list[1].isEmpty()) "HH..mm" else "HH.mm.ss"
                    LocalTime.parse(v, DateTimeFormatter.ofPattern(pattern2))
                } else if (list.size == 2) {
                    val h = Hours.fromDecimal(v.toDouble())
                    h.toLocalTime()
                } else null
            } catch (e: Exception) {
                null
            }
        }

        private fun tzCheck(v: String): ZoneOffset? {
            return try {
                ZoneOffset.ofHours(v.toInt())
            } catch (e: Exception) {
                null
            }
        }

        private fun degCheck(v: String, max: Degrees, min: Degrees): Degrees? {
            return try {
                val list = v.split('.')
                val deg = when (list.size) {
                    1 -> Degrees.fromDecimal(v.toInt())
                    2 -> Degrees.fromDecimal(v.toDouble())
                    3 -> run {
                        if(list[1].isEmpty()){
                            val listInt = list.map { it.toIntOrNull() }
                            Degrees.of(listInt[0]!!, listInt[2]!!, 0)
                        }else{
                            val listInt = list.map { it.toIntOrNull() }
                            Degrees.of(listInt[0]!!, listInt[1]!!, listInt[2]!!)
                        }

                    }
                    else -> return null
                }
                return if (deg <= max && deg >= min) {
                    deg
                } else {
                    null
                }
            } catch (e: Exception) {
                null
            }
        }

        private fun latCheck(v: String): Degrees? {
            return degCheck(v, (90).deg(), (-90).deg())
        }

        private fun lonCheck(v: String): Degrees? {
            return degCheck(v, (180).deg(), (-180).deg())
        }

        private fun altCheck(v: String): Int? {
            return try {
                v.toInt()
            } catch (e: Exception) {
                null
            }
        }
    }
}