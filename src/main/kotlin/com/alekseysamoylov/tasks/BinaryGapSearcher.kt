package com.alekseysamoylov.tasks

import java.util.HashMap


class BinaryGapSearcher {

    fun solution(N: Int): Int {
        val array = Integer.toBinaryString(N).toCharArray()
        var start = false
        var max = 0
        var current = 0
        for (i in array.indices.reversed()) {
            val b = array[i]
            if (b == '1') {
                if (!start) {
                    start = true
                }
            } else if (start && b == '0') {
                current++
                if (max < current) {
                    max = current
                }
            }
            if (start && b == '1' && current > 0) {
                current = 0
            }
        }
        return max
    }
}

// test
fun main() {
    // setup
    val service = BinaryGapSearcher()
    val testCases = HashMap<Int, Int>()
    testCases[9] = 2
    testCases[529] = 4
    testCases[20] = 1
    testCases[32] = 0
    testCases[1041] = 5

    // when
    for (entry in testCases.entries) {
        if (service.solution(entry.key) == entry.value) {
            println("Test passed $entry")
        } else {
            println("Wrong result $entry")
        }
    }
}
