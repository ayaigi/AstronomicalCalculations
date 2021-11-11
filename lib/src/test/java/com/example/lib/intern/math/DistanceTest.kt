package com.example.lib.intern.math

import org.junit.Test

class DistanceTest {

    @Test
    fun t() {
        val au1 = 10
        val dis = Distance.fromKm(au1)
        val au2 = dis.toKm()
        res("au1: $au1\nau2: $au2")
    }
    fun res(v: String){
        println("------\n------\n------\n$v\n------\n------\n------")
    }
}