package com.alekseysamoylov.tasks


class NumberOfFactorsCalculator {
    fun solution(N: Int): Int {
        if (N == 1) {
            return 1
        }
        var result = 0
        var i = 1
        while (i * i <= N) {
            if (N % i == 0) {
                result += 2
            }
            if (i * i == N) {
                result--
            }
            i++
        }
        return result
    }
}
