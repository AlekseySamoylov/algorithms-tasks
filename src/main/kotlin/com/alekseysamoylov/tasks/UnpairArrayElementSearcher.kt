package com.alekseysamoylov.tasks

// should return an unpaired element
fun solution(A: IntArray): Int {
    val resultMap = mutableMapOf<Int, Int>()
    A.forEach {
        when {
            resultMap[it] == -1 -> resultMap[it] = it
            resultMap[it] == null -> resultMap[it] = -1
            resultMap[it] == it -> resultMap[it] = -1
        }
    }

    return resultMap.entries.first { it.value == -1 }.key
}
// should return an unpaired element
fun solution2(A: IntArray): Int {
    val resultMap = mutableMapOf<Int, Int>()
    A.forEach {
        when {
            resultMap[it] == -1 -> resultMap.remove(it)
            resultMap[it] == null -> resultMap[it] = -1
        }
    }
    return resultMap.keys.first()
}

// test
fun main() {
    val resultMap: MutableMap<IntArray, Int> = mutableMapOf()
    resultMap[intArrayOf(9, 3, 9, 3, 9, 7, 9)] = 7

    resultMap.forEach { array, unpairedElement ->
        println("${array.joinToString()} ---- $unpairedElement")
        if (solution2(array) == unpairedElement) {
            println("Success")
        } else {
            println("Failed")
        }
    }
}




