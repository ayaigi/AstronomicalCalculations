package com.example.lib.intern.math

import com.example.vectors.Plane
import com.example.vectors.Vector
import com.example.vectors.degToRad
import com.example.vectors.radToDeg
import java.util.*

private val N = Vector(1, 0, 0)
private val S = Vector(-1, 0, 0)
private val SN = N - S
val nXY = Vector(0, 0, 1)

fun main() {
    val alt = 60f
    val azi = 90f

    val ca = ConvertAngles(alt.degToRad(), azi.degToRad())
    val gam = ca.Gamma
    val del = ca.Delta
    println("Gamma: $gam")
    println("Delta: $del")
}

/**
 * values in Radians
 */
internal class ConvertAngles(altitude: Float, azimuth: Float) {
    val Gamma: Float
    val Delta: Float

    init {
        val x = Vector.fromPolarH(altitude, azimuth)
        val p = Plane.fromPoints(x, N, S)
        val np = p.normalVector()

        val gamma = SN.angle(x).radToDeg()
        val delta = np.angle(nXY).radToDeg()
        Gamma = gamma
        Delta = delta
    }
}
/*
fun Float.format2(): String{
    return "%.2f".format(Locale.ENGLISH, this)
}
 */