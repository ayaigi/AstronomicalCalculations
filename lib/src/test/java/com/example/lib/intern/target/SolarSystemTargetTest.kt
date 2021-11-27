package com.example.lib.intern.target

import com.google.common.truth.Truth
import org.junit.Assert.*

import org.junit.Test

class SolarSystemTargetTest {

    @Test
    fun toT() {
        val s = (SolarSystemTarget.MOON)

        val t = (Target.fromID(3))

        println(s)
        println(t)

        val bool = (s.id == t.id)

        println(bool)

        Truth.assertThat(s).isEqualTo(t)
    }
}