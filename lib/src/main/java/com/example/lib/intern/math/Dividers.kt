package com.example.lib.intern.math

import kotlin.math.abs

internal class Dividers(org: Double) {
    private val int = org.toInt()
    private val fraction = org - int
    fun find(precision: Int): Triple<Int, Int, Double>? {
        return findRes(precision)?.run {
            Triple(
                first + int * second,
                second,
                first.toDouble() / second
            )
        }
    }
    fun findSmall(precision: Int): Triple<Int, Int, Double>? {
        return findResSmall(precision)?.run {
            Triple(
                first + int * second,
                second,
                first.toDouble() / second
            )
        }
    }
    private fun findRes(precision: Int): Pair<Int, Int>? {
        var precision = precision
        var leftTop = 0
        var leftBut = 1
        var rightTop = 1
        var rightBut = 1
        var tempTop = 0
        var tempBut = 0
        var res: Pair<Int, Int>? = null
        fun equals(x: Double, y: Double): Boolean {
            return abs(x - y) <  0.00001
        }
        fun equals(x: Double): Boolean {
            val div = abs(x - fraction)
            val com = div <  0.00001
            return com
        }
        fun calcLeft(): Double {
            return leftTop.toDouble() / leftBut
        }
        fun calcRight(): Double {
            return rightTop.toDouble() / rightBut
        }
        fun reCalcTemp(){
            tempTop = rightTop + leftTop
            tempBut = rightBut + leftBut
        }
        fun calcMid(): Double {
            return tempTop.toDouble() / tempBut
        }
        fun end(isLeft: Boolean){
            res = if (isLeft) {
                Pair(leftTop, leftBut)
            }else{
                Pair(rightTop, rightBut)
            }
            precision = 0
        }
        var left = calcLeft()
        var right = calcRight()
        fun reCalcRigLef(){
            left = calcLeft()
            right = calcRight()
        }
        reCalcTemp()
        var mid = calcMid()
        fun reCalcMid(inLeft: Boolean){
            if(inLeft) {
                rightTop = tempTop
                rightBut = tempBut
            }
            else {
                leftTop = tempTop
                leftBut = tempBut
            }
            reCalcTemp()
            mid = calcMid()
            reCalcRigLef()
        }
        while(precision > 0) {
            precision--
            when {
                equals(left) -> end(true)
                equals(right) -> end(false)
                else -> reCalcMid(fraction < mid)
            }
        }
        return res
    }
    private fun findResSmall(precision: Int): Pair<Int, Int>? {
        var precision = precision
        var leftTop = 0
        var leftBut = 1
        var rightTop = 1
        var rightBut = 1
        var tempTop = 0
        var tempBut = 0
        var res: Pair<Int, Int>? = null
        fun equals(x: Double, y: Double): Boolean {
            return abs(x - y) <  0.00001
        }
        fun equals(x: Double): Boolean {
            val div = abs(x - fraction)
            val com = div <  0.00001
            return com
        }
        fun calcLeft(): Double {
            return leftTop.toDouble() / leftBut
        }
        fun calcRight(): Double {
            return rightTop.toDouble() / rightBut
        }
        fun reCalcTemp(){
            tempTop = rightTop + leftTop
            tempBut = rightBut + leftBut
        }
        fun calcMid(): Double {
            return tempTop.toDouble() / tempBut
        }
        fun end(isLeft: Boolean){
            res = if (isLeft) {
                Pair(leftTop, leftBut)
            }else{
                Pair(rightTop, rightBut)
            }
            precision = 0
        }
        var left = calcLeft()
        var right = calcRight()
        fun reCalcRigLef(){
            left = calcLeft()
            right = calcRight()
        }
        reCalcTemp()
        var mid = calcMid()
        fun reCalcMid(inLeft: Boolean){
            if(inLeft) {
                rightTop = tempTop
                rightBut = tempBut
            }
            else {
                leftTop = tempTop
                leftBut = tempBut
            }
            reCalcTemp()
            mid = calcMid()
            reCalcRigLef()
        }
        fun small(): Boolean {
            return !(leftTop > precision || leftBut > precision || rightTop > precision || rightBut > precision)
        }
        while(small()) {
            when {
                equals(left) -> end(true)
                equals(right) -> end(false)
                else -> reCalcMid(fraction < mid)
            }
        }
        return res
    }
}