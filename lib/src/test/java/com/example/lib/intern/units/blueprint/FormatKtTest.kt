package com.example.lib.intern.units.blueprint

import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Test

class FormatKtTest{

    @Test
    fun unit(){
        val a = AstronomicalUnit.of(12, 13, 41).toString(UnitFormats.INTOMIN__)
        Truth.assertThat(a).isEqualTo("12° 13''")
        println(a)
    }
}