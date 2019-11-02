package com.alekseysamoylov.tasks

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


internal class NumberOfFactorsCalculatorTest {
    private val service = NumberOfFactorsCalculator()

    @ParameterizedTest
    @MethodSource("resultSource")
    fun `should return corect number of factors`(arg: Int, expectedResult: Int) {
        val result = service.solution(arg)
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun resultSource() = listOf(
            Arguments.of(24, 8),
            Arguments.of(2, 2),
            Arguments.of(3, 2),
            Arguments.of(4, 3),
            Arguments.of(5, 2),
            Arguments.of(6, 4),
            Arguments.of(8, 4),
            Arguments.of(1, 1),
            Arguments.of(2147_395_600, 163)
        )
    }
}
