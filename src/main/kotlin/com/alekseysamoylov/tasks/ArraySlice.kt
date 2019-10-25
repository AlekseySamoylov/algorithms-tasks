package com.alekseysamoylov.tasks

import java.util.concurrent.CopyOnWriteArrayList


class ArraySlice {
    fun solution(A: IntArray): Int {
        val resultList: MutableList<IntWrap> = CopyOnWriteArrayList()
        if (A.size == 1) {
            return A[0]
        }
        A.forEach { arrayElement ->
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
    }

    data class IntWrap(var slice: Int, var finished: Boolean = false)
}
