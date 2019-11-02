package com.alekseysamoylov.tasks

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


internal class SemiprimeSearcherTest {
    private val service = SemiprimeSearcher()

    @ParameterizedTest
    @MethodSource("testCases")
    fun `should return semiprime array result`(arg: Int, firstArray: IntArray, secondAray: IntArray, expectedResult: IntArray) {
        val result = service.solution(arg, firstArray, secondAray)
        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun `should get all semiprimes in 50 000 array`() {
        val result = service.getAllSemiprimes()
        result.sort()
        println(result.joinToString())
        assertThat(result).contains(4, 6, 9, 10, 14, 15, 21, 22, 25, 26)
    }

    companion object {
        @JvmStatic
        fun testCases() = listOf(
            Arguments.of(26, intArrayOf(1,4,16), intArrayOf(26,10,20), intArrayOf(10,4,0)),
            Arguments.of(20, intArrayOf(1,4,16), intArrayOf(26,10,20), intArrayOf(6,4,0))
        )
    }
}


