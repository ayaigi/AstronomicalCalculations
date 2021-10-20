package com.example.lib.intern.math


data class Distance private constructor(private val value: Long) { //value in meter
    internal companion object {
        fun fromMeter(v: Double) = Distance(v.toLong())
        fun fromMeter(v: Int) = Distance(v.toLong())
        fun fromAU(v: Double) = Distance((v * 149_597_870_700).toLong())
        fun fromAU(v: Int) = Distance((v * 149_597_870_700))
        fun fromKm(v: Double) = Distance((v * 1000).toLong())
        fun fromKm(v: Int) = Distance((v * 1000).toLong())
        fun fromEarthRadii(v: Double) = Distance((v * 6_371_009).toLong())
        fun fromEarthRadii(v: Int) = Distance((v * 6_371_009).toLong())
    }
    fun toMeter() = value
    fun toAU() = value / 149_597_870_700.0
    fun toKm() = value / 1000.0
    fun toEarthRadii() = value / 6_371_008.8
}