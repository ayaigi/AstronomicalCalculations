package com.example.lib.intern.math

import org.junit.Test

class DistanceTest {

    @Test
    fun t() {
        val d = Distance.run{
            listOf(fromAU(0.05), fromAU(0.4), fromAU(1.0), fromAU(1.5), fromAU(15))
        }
        val s = d.map { it.toString() }

        println(s)
    }
    @Test
    fun f() {
        val d = Distance.fromAU(1).lightTime()

        println(d)
    }
}