package com.alekseysamoylov.tasks

import java.lang.Integer.max


class StockProfitCalculator {
    fun solution(A: IntArray): Int {
        if (A.size < 2) {
            return 0
        }
        var maxResult: Int = 0
        var previousMinBuy = A[0]
        for (stockPrice in A) {
            val currentSoldPrice = stockPrice - previousMinBuy
            if (currentSoldPrice <= 0) {
                previousMinBuy = stockPrice
            } else {
                maxResult = max(maxResult, currentSoldPrice)
            }
        }
        return maxResult
    }
}
