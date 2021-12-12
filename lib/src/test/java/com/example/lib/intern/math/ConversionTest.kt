package com.example.lib.intern.math

import com.example.vectors.degToRad
import com.example.vectors.radToDeg
import org.junit.Test

private fun main(){
    ConversionTest()
}

private fun ConversionTest(){
    val altitude = 90f.degToRad()
    val azimuth = 0f.degToRad()

    val (Gamma, Delta) = ConvertAngles(altitude, azimuth).run{
        val gamma = "%.2f".format(this.Gamma.radToDeg())
        val delta = "%.2f".format(this.Delta.radToDeg())
        Pair(gamma, delta)
    }

    println("Gamma: $Gamma")
    println("Delta: $Delta")
}