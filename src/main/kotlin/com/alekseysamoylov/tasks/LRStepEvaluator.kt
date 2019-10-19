package com.alekseysamoylov.tasks

import java.util.ArrayList


fun solution55(expectedValue: Int): String {
    var lr = LR()
    var stringCommand = ""
    var mistakes = 0
    var previousLetter = ""
    while (mistakes < 4) {
        if (lr.L == expectedValue || lr.R == expectedValue) {
            return stringCommand
        } else {
            if (expectedValue < 0 && (expectedValue < lr.checkApplyL())) {
                lr.applyL()
                if (previousLetter != "L") {
                    mistakes++
                }
                stringCommand += "L"
                previousLetter = "L"
            } else if (expectedValue > lr.checkApplyR() || expectedValue < (2 * lr.R - lr.checkApplyL())) {
                lr.applyR()
                if (previousLetter != "R") {
                    mistakes++
                }
                stringCommand += "R"
                previousLetter = "R"
            } else {
                mistakes++
            }
        }
    }
    return "impossible"
}

fun isPowerOfTwo(input : Int): Boolean {
    return Math.ceil(Math.log(input.toDouble()) / Math.log(2.0)).toInt() == Math.floor(
        Math.log(input.toDouble()) / Math.log(
            2.0
        )
    ).toInt()
}

fun isPowerOfTwoMinusOne(input: Int): Boolean {
    val root = Math.ceil(Math.log(input.toDouble()) / Math.log(2.0)).toInt()
    return Math.pow(2.0, root.toDouble()) - 1 == input.toDouble()
}

fun solution(input: Int): String {
    var N = input
    if (N == 0 || N == 1)
        return ""

    var negated = false
    var isPowerOfTwo = false
    var isPowerOfTwoMinusOne = false

    if (N < 0) {
        N = -N
        negated = true
    } else {
        isPowerOfTwo = isPowerOfTwo(N)
        isPowerOfTwoMinusOne = isPowerOfTwoMinusOne(N)
    }


    val commands = ArrayList<String>()
    while (N > 0) {
        if (N % 2 == 0) {
            commands.add("R")
        } else {
            if (isPowerOfTwo)
                commands.add("R")
            else
                commands.add("L")
        }
        N /= 2
    }

    val finalCommand = StringBuilder()

    if (negated) {
        for (command in commands) {
            finalCommand.append(command)
        }
    } else if (isPowerOfTwo || isPowerOfTwoMinusOne) {
        if (isPowerOfTwoMinusOne)
            finalCommand.append("L")

        for (i in 1 until commands.size) {
            finalCommand.append("R")
        }
    } else {
        for (i in commands.indices.reversed()) {
            finalCommand.append(commands[i])
        }
    }

    return finalCommand.toString()
}


class LR {
    var L = 0
    var R = 1

    fun checkApplyL(): Int {
        return 2 * L - R
    }
    fun applyL() {
        L = 2 * L - R
    }

    fun checkApplyR(): Int {
        return 2 * R - L
    }

    fun applyR() {
        R = 2 * R - L
    }
}


// test
fun main() {
    val given = -11
    val expectedResult = "LLRL"

    val result = solution55(given)
    if (expectedResult == result) {
        println("Succes")
    } else {
        println("Failed")
    }
}
