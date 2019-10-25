package com.alekseysamoylov.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Collectors
import java.util.stream.IntStream
import java.util.stream.Stream




internal class ArraySliceTest {
    private val service = ArraySlice()

    @ParameterizedTest
    @MethodSource("squares")
    fun `should slice array`(array: IntArray, expectedResult: Int) {
        val result = service.solution(array)
        assertThat(result).isEqualTo(expectedResult)
    }

//    @Test
//    fun iterator() {
////        val array = Stream.iterate(-99, { n -> n + 1 })
////            .limit(99).toArray()
////        val array = IntStream.rangeClosed(-999999, -1)
////            .boxed().toArray()
////        val array: IntArray = IntArray(99999) { i -> counter++ }
//        println(array[0])
//        println(array[array.size -1])
//    }

    companion object {
        var counter = -99

        @JvmStatic
        fun squares() = listOf(
            Arguments.of(intArrayOf(3,2,-1000,2,-6,4,992,-2,4,0,2,-6,4,0,2,-6,4,99,2,-6,4,0), 1099),
            Arguments.of(intArrayOf(3,2,-6,4,0,2,-6,4,0,2,-6,4,99,2,-6,4,0), 105),
            Arguments.of(intArrayOf(3,2,-6,4,0), 5),
            Arguments.of(intArrayOf(3,2,-6,4,0), 5),
            Arguments.of(intArrayOf(-3,5), 5),
            Arguments.of(intArrayOf(3,-5,-8), 3),
            Arguments.of(intArrayOf(8,-5,7), 10),
//            Arguments.of( IntArray(99) { counter++ }, -1),
            Arguments.of(intArrayOf(-10,-5,-2), -2)
        )
    }
}
