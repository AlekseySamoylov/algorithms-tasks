package com.alekseysamoylov.tasks

import java.util.*


/**
 * length of array and numberOfRotations are integers within the range [0..100];
 * each element of array is an integer within the range [−1,000..1,000].
 */
fun solution(array: IntArray, numberOfRotations: Int): IntArray {
    val resultArray = IntArray(array.size)
    var startIndex = numberOfRotations
    if (numberOfRotations == array.size) {
        return array
    } else {
        array.forEach {
            if (startIndex > (array.size - 1)) {
                startIndex = 0
            }
            resultArray[startIndex] = it
            startIndex++
        }
    }
    return resultArray
}


fun main() {
    val array = intArrayOf(3, 8, 9, 7, 6)
    val expectedResultArray = intArrayOf(9, 7, 6, 3, 8)
    val numberOfRotations = 3

    val resultArray = solution(array, numberOfRotations)

    if (Arrays.equals(expectedResultArray, resultArray)) {
        println("Passed")
    } else {
        println("Failed")
    }
}
