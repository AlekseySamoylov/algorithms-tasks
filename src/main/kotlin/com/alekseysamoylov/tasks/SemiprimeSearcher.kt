package com.alekseysamoylov.tasks

import java.util.concurrent.CopyOnWriteArrayList


class SemiprimeSearcher {
    fun solution(N: Int, P: IntArray, Q: IntArray): IntArray {
        val allNumbersMarkedArray = getAllSemiprimesSpecificAray()
        val result = IntArray(P.size)
        assert(P.size == Q.size)
        for (i in P.indices) {
            val start = P[i]
            var finish = Q[i]
            if (finish > N) {
                finish = N
            }
            var iterator = start -1
            var resultCounter = 0
            while (iterator < finish) {
                if (iterator == 0) {
                    iterator++
                    continue
                }
                val element = allNumbersMarkedArray[iterator]
                if (element == 1) {
                    resultCounter++
                }
                iterator++
            }
            result[i] = resultCounter
        }
        return result
    }

    fun getAllSemiprimes(): IntArray {
        val primeList: MutableList<Int> =
            CopyOnWriteArrayList(ArrayList(25_000))
        val allNumbersArray = IntArray(50_000) { i -> (i + 1) }
        val resultList = mutableListOf<Int>()

        for (i in 0..49_000) {
            val multiplier = i + 1
            if (multiplier == 1) {
                continue
            }
            if (allNumbersArray[i] == 1 || allNumbersArray[i] == -1) {
                for (primeMultiplier in primeList) {
                    val result = multiplier * primeMultiplier
                    if (result < 1 || result > 50_000) {
                        break
                    }
                    allNumbersArray[result - 1] = -1
                }
                continue
            }
            allNumbersArray[i] = 0
            primeList.add(multiplier)
            for (primeMultiplier in primeList) {
                val result = multiplier * primeMultiplier
                if (result < 1 || result > 50_000) {
                    break
                }
                allNumbersArray[result - 1] = 1
                resultList.add(result)
            }
        }
        return resultList.toIntArray()
    }

    fun getAllSemiprimesSpecificAray(): IntArray {
        val primeList: MutableList<Int> =
            CopyOnWriteArrayList(ArrayList(25_000))
        val allNumbersArray = IntArray(50_000) { i -> (i + 1) }
        for (i in 0..49_000) {
            val multiplier = i + 1
            if (multiplier == 1) {
                continue
            }
            if (allNumbersArray[i] == 1 || allNumbersArray[i] == -1) {
                for (primeMultiplier in primeList) {
                    val result = multiplier * primeMultiplier
                    if (result < 1 || result > 50_000) {
                        break
                    }
                    allNumbersArray[result - 1] = -1
                }
                continue
            }
            allNumbersArray[i] = 0
            primeList.add(multiplier)
            for (primeMultiplier in primeList) {
                val result = multiplier * primeMultiplier
                if (result < 1 || result > 50_000) {
                    break
                }
                allNumbersArray[result - 1] = 1
            }
        }
        return allNumbersArray
    }
}


