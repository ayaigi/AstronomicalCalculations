package com.example.lib.port

import org.junit.Assert.*

import org.junit.Test
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

class AstronomicalResultsTest {

    @Test
    fun getOffsetDateTime() {
        val ODT = OffsetDateTime.of(2020, 12, 20, 12, 0, 0, 0, ZoneOffset.ofHours(2))
        val LDT = ODT.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()
        println("---------------------------")
        println("---------------------------")
        println("---------------------------")
        println("ODT: $ODT")
        println("LDT: $LDT")
        println("---------------------------")
        println("---------------------------")
        println("---------------------------")
    }
}