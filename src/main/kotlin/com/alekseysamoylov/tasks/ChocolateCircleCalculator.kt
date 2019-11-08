package com.alekseysamoylov.tasks


class ChocolateCircleCalculator {
    fun solution(N: Int, M: Int): Int {
        if (N == 1) {
            return 1
        }
        var first: CircleGraphElement? = null
        var previousElement: CircleGraphElement? = null
        for (i in 0 until N) {
            val current = CircleGraphElement(null, i)
            if (previousElement != null) {
                previousElement.next = current
            } else {
                first = current
            }
            previousElement = current
        }
        previousElement?.let {
           it.next = first
        }
        var result = 1
        var selector: CircleGraphElement = first!!
        selector.value = -1
        val optimizedM = getMaxDevider(N,M)
        while (true) {
            for (k in 0 until optimizedM) {
                selector = selector.next!!
            }
            if (first !== selector && selector.value == -1) {
                break
            }
            if (selector.value != -1) {
                selector.value = -1
                result ++
            }
        }
        return result
    }

    fun solution2(N: Int, M: Int): Int {
        if (N == 1) {
            return 1
        }
        val optimizedM = getMaxDevider(N,M)
        return N / optimizedM
    }


    tailrec fun getMaxDevider(a: Int, b: Int): Int {
        if (a == 0) {
            return b
        }
        if (b == 0) {
            return a
        }
        if (a > b) {
            return getMaxDevider(a.rem(b), b)
        }
        if (b > a) {
            return getMaxDevider(b.rem(a), a)
        }
        return a
    }
    data class CircleGraphElement(var next: CircleGraphElement? = null, var value: Int)
}
