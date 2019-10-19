package com.alekseysamoylov.tasks

import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicIntegerArray
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import java.util.stream.Collectors


class TwoOpperationsArrayModifier {
}

fun solutionTwoOpperationsArrayModifier(N: Int, A: IntArray): IntArray {
    var counters = IntArray(N)
    var maxCounter = 0
    A.forEach {
        if (it in 1 until N) {
            counters[it - 1]++
            if (maxCounter < counters[it - 1]) {
                maxCounter = counters[it - 1]
            }
        } else if (it == N + 1) {
            counters = IntArray(N) { maxCounter }
        }
    }
    return counters
}


// test
fun main() {
    val array: IntArray = intArrayOf(3, 4, 4, 6, 1, 4, 4)
    val number = 5
    val expectedResult: IntArray = intArrayOf(3, 2, 2, 4, 2)

    val result = solutionTwoOpperationsArrayModifier(number, array)

    println(Arrays.toString(result))
    if (expectedResult contentEquals result) {
        println("Succes")
    } else {
        println("Failed")
    }
}
