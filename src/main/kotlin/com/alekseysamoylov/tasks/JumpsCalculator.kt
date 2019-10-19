package com.alekseysamoylov.tasks

fun solution1(x: Int, y: Int, jumpLength: Int): Int {
    var jumpNumber = 0
    var position = x
    while (true) {
        jumpNumber++
        position += jumpLength
        if (position >= y) {
            return jumpNumber
        }
    }
}
fun solution2(x: Int, y: Int, jumpLength: Int): Int {
    val rawResult : Double = (y.toDouble() - x) / jumpLength
    return if (rawResult % 1 == 0.0) {
        rawResult.toInt()
    } else {
        rawResult.toInt() + 1
    }
}

// test
fun main() {
    val x = 10
    val y = 85
    val jumpLength = 30
    val expectedJumpNumber = 3
    val result = solution2(x,y, jumpLength)
    if (expectedJumpNumber == result) {
        println("Passed")
    } else {
        println("Failed")
    }
}
