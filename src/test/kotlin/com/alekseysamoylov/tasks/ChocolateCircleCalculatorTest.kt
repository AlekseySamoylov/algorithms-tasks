package com.alekseysamoylov.tasks

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


internal class ChocolateCircleCalculatorTest {
    private val service = ChocolateCircleCalculator()

    @ParameterizedTest
    @MethodSource("testCases")
    fun `should return semiprime array result`(firstArg: Int, secondArg: Int, expectedResult: Int) {
        val result = service.solution2(firstArg, secondArg)
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(10, 4, 5),
            Arguments.of(10, 3334, 5),
            Arguments.of(1, 1, 1)
        )
    }
}
