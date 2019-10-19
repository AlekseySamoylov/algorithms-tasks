package com.alekseysamoylov.tasks

import kotlin.collections.HashMap


class DominatorAray {
    fun solution(A: IntArray): Int {

        val numberCounterMap: MutableMap<Int, Int> = HashMap(100_000)
        if (A.size == 1) {
            return 0
        }
        var dominatorValue: Int? = null
        var dominatorCounter: Int = 0
        val threshold = A.size / 2

        for (i in A.indices) {
            val it = A[i]
            var numberCounter = numberCounterMap[it]
            if (numberCounter != null) {
                numberCounter++
                numberCounterMap[it] = numberCounter
                if (dominatorValue != null) {
                    if (dominatorValue == it) {
                        dominatorCounter++
                        if (dominatorCounter > threshold) {
                            return i
                        }
                    } else if (numberCounter > dominatorCounter) {
                        dominatorValue = it
                        dominatorCounter = numberCounter
                    }
                } else {
                    dominatorValue = it
                    dominatorCounter = 1
                }
            } else {
                numberCounterMap[it] = 1
                dominatorValue = it
                dominatorCounter = 1
            }
        }

        return -1
    }
}

// Test
fun main() {
    // Given
    val array = intArrayOf(3,3,2)
//    val array = intArrayOf(3,4)
//    val array = intArrayOf(3,4,4)
//    val array = intArrayOf()
    val expectedResult = listOf(0,2,4,6,7)

    val result = DominatorAray().solution(array)

    println(result)
    if (expectedResult.contains(result)) {
        println("Passed")
    } else {
        println("Failed")
    }
}
