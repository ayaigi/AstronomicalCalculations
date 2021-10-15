package com.example.lib.intern.units.blueprint

private data class astrUnitsBluePrintsInter(override var value: Long) : astrUnitInter {
    constructor(value: Double) : this(value.toLongExept())

    operator fun plus(v: astrUnitsBluePrintsInter) = astrUnitsBluePrintsInter(value.plus(v.value))

    operator fun minus(v: astrUnitsBluePrintsInter) = astrUnitsBluePrintsInter(value.minus(v.value))

    operator fun plusAssign(v: astrUnitsBluePrintsInter) {
        astrUnitsBluePrintsInter(value.plus(v.value))
    }

    operator fun minusAssign(v: astrUnitsBluePrintsInter) {
        astrUnitsBluePrintsInter(value.minus(v.value))
    }

    operator fun times(v: Double) = astrUnitsBluePrintsInter(value.times(v))

    operator fun times(v: Int) = astrUnitsBluePrintsInter(value.times(v))

    operator fun div(v: Double) = astrUnitsBluePrintsInter(value.div(v))

    operator fun div(v: Int) = astrUnitsBluePrintsInter(value.div(v))

    operator fun dec() = astrUnitsBluePrintsInter(value.dec())

    operator fun inc() = astrUnitsBluePrintsInter(value.inc())

    operator fun compareTo(v: astrUnitsBluePrintsInter) = value.compareTo(v.value)

    operator fun unaryMinus() = astrUnitsBluePrintsInter(value.unaryMinus())
}

fun Double.toLongExept(): Long {
    return if (this > Long.MAX_VALUE) {
        throw Exception("out of Range: $this")
    } else {
        this.toLong()
    }
}
fun sign(v: Long): Int {
    return when {
        v < 0 -> -1
        v > 0 -> 1
        else -> 0
    }
}
/*
package com.example.templibastr.intern.units

//const val INVALID_RECEIVER = "invalid Receiver"

class astrUnitsBluePrint(override var value: Double): astrUnit {
    constructor(value: Int): this(value.toDouble())

    operator fun plus(v: astrUnitsBluePrint): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.plus(v.value))
    }
    operator fun minus(v: astrUnitsBluePrint): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.minus(v.value))
    }
    operator fun plusAssign(v: astrUnitsBluePrint) {
        astrUnitsBluePrint(value.plus(v.value))
    }
    operator fun minusAssign(v: astrUnitsBluePrint) {
        astrUnitsBluePrint(value.minus(v.value))
    }
    operator fun times(v: Double): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.times(v))
    }
    operator fun times(v: Int): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.times(v))
    }
    operator fun div(v: Double): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.div(v))
    }
    operator fun div(v: Int): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.div(v))
    }
    operator fun dec(): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.dec())
    }
    operator fun inc(): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.inc())
    }
    operator fun compareTo(v: astrUnitsBluePrint) : Int {
        return value.compareTo(v.value)
    }
    operator fun unaryMinus(): astrUnitsBluePrint {
        return astrUnitsBluePrint(value.unaryMinus())
    }
}
 */