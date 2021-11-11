package com.example.lib.intern.math


data class Distance private constructor(private val value: Float) { //value in meter
    companion object {
        fun fromMeter(v: Double) = Distance(v.toFloat())
        fun fromMeter(v: Int) = Distance(v.toFloat())
        fun fromMeter(v: Float) = Distance(v)
        fun fromAU(v: Double) = Distance((v * 149_597_870_700).toFloat())
        fun fromAU(v: Int) = Distance((v * 149_597_870_700).toFloat())
        fun fromAU(v: Float) = Distance((v * 149_597_870_700))
        fun fromKm(v: Double) = Distance((v * 1000).toFloat())
        fun fromKm(v: Int) = Distance((v * 1000).toFloat())
        fun fromKm(v: Float) = Distance((v * 1000))
        fun fromEarthRadii(v: Double) = Distance((v * 6_371_009).toFloat())
        fun fromEarthRadii(v: Int) = Distance((v * 6_371_009).toFloat())
        fun fromEarthRadii(v: Float) = Distance((v * 6_371_009))
    }
    fun toMeter() = value
    fun toAU() = value / 149_597_870_700.0f
    fun toKm() = value / 1000.0f
    fun toEarthRadii() = value / 6_371_008.8f
}