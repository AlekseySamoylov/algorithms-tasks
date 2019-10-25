package com.alekseysamoylov.tasks








fun solution5(array: IntArray): Int {
    if (array.size < 2) {
        return -2
    }
    array.sort()
    val distanceConst = 100_000_001
    var minDistance = distanceConst
    for (i in array.indices) {
        if (i == 0) {
            continue
        }
        val distance = array[i] - array[i-1]
        if (minDistance > distance) {
            minDistance = distance
        }
    }
    return if (minDistance == distanceConst) {
        -1
    } else {
        minDistance
    }
}

fun solution6(array: IntArray): Int {
    if (array.size < 2) {
        return -2
    }
    array.sort()
    var minDistance = 100_000_001
    for (i in array.indices) {
        if (i == 0) {
            continue
        }
        val distance = array[i] - array[i-1]
        if (minDistance > distance) {
            minDistance = distance
        }
    }
    if (minDistance == 100_000_001) {
        return -1
    } else {
        return minDistance
    }
}

fun main() {
    val array = intArrayOf(0,3,3,7,5,3,11,1)
    val expectedResult = 0

    val result = solution5(array)

    if (expectedResult == result) {
        println("Passed")
    } else {
        println("Failed")
    }
}
