package com.example.astronomicalcalculations.intern.solarSystem

import com.example.astronomicalcalculations.intern.units.Degrees

internal fun getPlanet(id: Int) = Planets.values()[id - 1]

internal enum class Planets(
    val id: Int,
    val innerOuter: Boolean,
    val periodTp: Double,
    val longEpsilon: Degrees,
    val longPerihelionOmega: Degrees,
    val eccentricityE: Double,
    val semiMajorAxisAAU: Double,
    val inclinationI: Degrees,
    val longAscendingNodeGOmega: Degrees,
    val angularSize1AUTheta0: Double,
    val brightnissfactorA: Double,
) {
    MERCURY(
        1,
        true,
        0.24085,
        Degrees.fromDecimal(231.2973),
        Degrees.fromDecimal(77.1442128),
        0.2056306,
        0.3870986,
        Degrees.fromDecimal(7.0043579),
        Degrees.fromDecimal(48.0941733),
        6.74,
        1.918 * 10E-6
    ),
    VENUS(
        2,
        true,
        0.61521,
        Degrees.fromDecimal(355.73352),
        Degrees.fromDecimal(131.2895792),
        0.0067826,
        0.7233316,
        Degrees.fromDecimal(3.394435),
        Degrees.fromDecimal(76.4997524),
        16.92,
        1.721 * 10E-5
    ),
    EARTH(
        3,
        true,
        1.00004,
        Degrees.fromDecimal(98.833540),
        Degrees.fromDecimal(102.596403),
        0.016718,
        1.0,
        Degrees.fromDecimal(1.0),
        Degrees.fromDecimal(0.0),
        0.0,
        0.0
    ),
    MARS(
        4,
        false,
        1.88089,
        Degrees.fromDecimal(126.30783),
        Degrees.fromDecimal(335.6908166),
        0.0933865,
        1.5236883,
        Degrees.fromDecimal(1.8498011),
        Degrees.fromDecimal(49.4032001),
        9.36,
        4.539 * 10E-6
    ),
    JUPITER(
        5,
        false,
        11.86224,
        Degrees.fromDecimal(146.966365),
        Degrees.fromDecimal(14.0095493),
        0.0484658,
        5.202561,
        Degrees.fromDecimal(1.3041819),
        Degrees.fromDecimal(100.2520175),
        196.74,
        1.994 * 10E-4
    ),
    SATURN(
        6,
        false,
        29.45771,
        Degrees.fromDecimal(165.322242),
        Degrees.fromDecimal(92.6653974),
        0.0556155,
        9.554747,
        Degrees.fromDecimal(2.4893741),
        Degrees.fromDecimal(113.4888341),
        165.60,
        1.740 * 10E-4
    ),
    URANUS(
        7,
        false,
        84.01247,
        Degrees.fromDecimal(228.0708551),
        Degrees.fromDecimal(172.7363288),
        0.0463232,
        19.21814,
        Degrees.fromDecimal(0.7729895),
        Degrees.fromDecimal(73.8768642),
        65.80,
        7.768 * 10E-5
    ),
    NEPTUNE(
        8,
        false,
        164.79558,
        Degrees.fromDecimal(260.3578998),
        Degrees.fromDecimal(47.8672148),
        0.0090021,
        30.10957,
        Degrees.fromDecimal(1.7716017),
        Degrees.fromDecimal(131.5606494),
        62.20,
        7.597 * 10E-5
    ),
    PLUTO(
        9,
        false,
        250.9,
        Degrees.fromDecimal(209.4399),
        Degrees.fromDecimal(222.972),
        0.25387,
        39.78459,
        Degrees.fromDecimal(17.137),
        Degrees.fromDecimal(109.941),
        8.20,
        4.073 * 10E-6
    )
}