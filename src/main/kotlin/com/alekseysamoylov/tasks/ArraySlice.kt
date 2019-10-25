package com.alekseysamoylov.tasks

import kotlin.math.max


class ArraySlice {
    fun solution(A: IntArray): Int {
        var maxSum: Int = A[0]
        var previousSum = 0
        A.forEach { element ->
            val current = previousSum + element
            previousSum = when {
                current > 0 -> current
                else -> 0
            }
            maxSum = max(maxSum, current)
        }
        return maxSum
    }

/*
    fun badSolution(A: IntArray): Int {
        val resultList: MutableList<IntWrap> = CopyOnWriteArrayList()
        if (A.size == 1) {
            return A[0]
        }
        val maximalElement = A.max()
        if (maximalElement!! <= 0) {
            return maximalElement
        }

        val simplifiedA: MutableList<Int> = mutableListOf()
        var sumOfNegativeSequence = 0
        var sumOfPositiveSequence = 0
        var previousElement = 0
        A.forEach {
            if (it < 0) {
                if (sumOfPositiveSequence > 0) {
                    simplifiedA.add(sumOfPositiveSequence)
                    sumOfPositiveSequence = 0
                    previousElement = it
                }

                if (sumOfNegativeSequence == 0) {
                    sumOfNegativeSequence = it
                    previousElement = it
                } else {
                    if (previousElement < it) {
                        sumOfNegativeSequence += it
                        previousElement = it
                    }
                }
            } else {
                if (sumOfNegativeSequence < 0) {
                    simplifiedA.add(sumOfNegativeSequence)
                    sumOfNegativeSequence = 0
                    sumOfPositiveSequence += it
                } else {
                    sumOfPositiveSequence += it
                    previousElement = it
                }
            }
        }
        if (sumOfNegativeSequence != 0) {
            simplifiedA.add(sumOfNegativeSequence)
        } else if (sumOfPositiveSequence != 0) {
            simplifiedA.add(sumOfPositiveSequence)
        }

        simplifiedA.forEach { arrayElement ->
            var createNewResultArrayForNextPositive = false
            if (resultList.size > 0) {
                for (i in resultList.indices) {
                    var maxSlice = resultList[i]
                    if (maxSlice.finished) {
                        continue
                    }
                    if (maxSlice.slice < 0) {
                        createNewResultArrayForNextPositive = true
                    }
                    if (createNewResultArrayForNextPositive && arrayElement > maxSlice.slice) {
                        resultList.add(IntWrap(arrayElement))
                        createNewResultArrayForNextPositive = false
                    }
                    val tempSlice = maxSlice.slice + arrayElement
                    if (tempSlice >= maxSlice.slice) {
                        maxSlice.slice = tempSlice
                    } else {
                        val finishedMaxSlice = IntWrap(maxSlice.slice, true)
                        resultList.add(finishedMaxSlice)
                        createNewResultArrayForNextPositive = true
                        maxSlice.slice = tempSlice
                    }
                }
            } else {
                val firstResult = IntWrap(arrayElement)
                resultList.add(firstResult)
            }
        }

        return resultList.maxBy { it.slice }!!.slice
    }*/

    data class IntWrap(var slice: Int, var finished: Boolean = false)
}
