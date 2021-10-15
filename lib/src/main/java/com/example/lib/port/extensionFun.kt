package com.example.lib.port

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

fun OffsetDateTime.toUTC() : LocalDateTime {
    return this.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()
}
//fun OffsetDateTime.toUTC() = this.atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime()