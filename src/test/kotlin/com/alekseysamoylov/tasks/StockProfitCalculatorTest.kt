package com.alekseysamoylov.tasks

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


internal class StockProfitCalculatorTest {

    private val service: StockProfitCalculator = StockProfitCalculator()

    @ParameterizedTest
    @MethodSource("stocksCases")
    fun `should calculate best stock slice`(array: IntArray, expectedResult: Int) {
        val result = service.solution(array)
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun stocksCases() = listOf(
            Arguments.of(intArrayOf(23171, 21011,21123,21366,21013,21367), 356),
            Arguments.of(intArrayOf(1,2), 1),
            Arguments.of(intArrayOf(2,1), 0)
        )
    }
}
