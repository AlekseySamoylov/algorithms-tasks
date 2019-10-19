package com.alekseysamoylov.tasks





fun solution8(array: IntArray): Int {
    val distinctValues = array.distinct()
    var minNumberOfDays = Int.MAX_VALUE
    val tempDistinctValuesChecker = ArrayList<Int>(distinctValues.size)
    tempDistinctValuesChecker.addAll(distinctValues)
    var tempDaysCounter = 0
    for (i in array.indices) {
        var j = i
        while (j < array.size) {
            val element = array[j]
            if (tempDistinctValuesChecker.isEmpty()) {
                if (minNumberOfDays > tempDaysCounter) {
                    minNumberOfDays = tempDaysCounter
                }
                tempDaysCounter = 0
                tempDistinctValuesChecker.addAll(distinctValues)
            } else {
                tempDistinctValuesChecker.remove(element)
                tempDaysCounter++
            }
            j++
        }
    }
    return minNumberOfDays
}

// test
fun main() {
    val testArray1 = intArrayOf(7,3,7,3,1,3,4,1)
    val expectedResult = 5

    val result = solution8(testArray1)
    if (expectedResult == result) {
        println("Succes")
    } else {
        println("Failed")
    }
}
