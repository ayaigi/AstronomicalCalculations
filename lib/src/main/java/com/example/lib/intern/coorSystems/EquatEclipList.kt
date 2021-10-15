package com.example.lib.intern.coorSystems

import com.example.lib.intern.units.Degrees
import java.time.LocalDateTime

internal class EquatEclipList(val dateTime: LocalDateTime) {
    val epsilon: Degrees = EclipticSys.epsilon(dateTime)

    lateinit var switchHeight: Degrees
    lateinit var switchRound: Degrees

    /**
     * Lambda: Degrees
     *
     * Betta: Degrees
     */
    fun toEquat(list: List<Pair<Degrees, Degrees>>){
        val result = mutableListOf<Pair<Degrees, Degrees>>()
        for(i in list){
            result.add(switchEntity(i))
        }
    }

    /**
     * RightAscension: Degrees
     *
     * Declination: Degrees
     */
    fun toEclipD(list: List<Pair<Degrees, Degrees>>){
        val result = mutableListOf<Pair<Degrees, Degrees>>()
        for (i in list){
            result.add(switchEntity(i))
        }
    }

    /*
    /**
     * RightAscension: Hours
     *
     * Declination: Degrees
     */
    fun toEclipH(list: List<Pair<Hours, Degrees>>){
        val list = list.map {
            it.run{
                Pair(first.toDegrees(), second)
            }
        }
        val result = mutableListOf<Pair<Degrees, Degrees>>()
        for (i in list){
            result.add(switchEntity(i))
        }
    }

     */


    private fun switchEntity(v: Pair<Degrees, Degrees>): Pair<Degrees, Degrees> {
        switchRound = Degrees.rmvAmbiguity(((v.first.sin() * epsilon.cos()) - (v.second.tan() * epsilon.sin())), (v.first.cos()))
        switchHeight = Degrees.aSin((v.second.sin() * epsilon.cos()) + (v.second.cos() * epsilon.sin() * v.first.sin()))
        return Pair(switchRound, switchHeight)
    }
}