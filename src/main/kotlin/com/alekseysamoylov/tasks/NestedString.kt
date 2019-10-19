package com.alekseysamoylov.tasks

import java.util.*


class NestedString {
    fun nestedStringSolution(S: String): Int {
        var parentheses = 0
        var qurvedParentheses = 0
        var squareParentheses = 0
        S.toCharArray().forEach {
            when (it) {
                '(' -> parentheses++
                ')' -> parentheses--
                '[' -> squareParentheses++
                ']' -> squareParentheses--
                '{' -> qurvedParentheses++
                '}' -> qurvedParentheses--
            }
        }
        return if (parentheses == 0 && qurvedParentheses == 0 && squareParentheses == 0) {
            1
        } else {
            0
        }
    }

    fun nestedStringSolution2(S: String): Int {
        val stack = Stack<Char>()
        S.toCharArray().forEach {
            when (it) {
                '(' -> stack.push('(')
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop()
                    } else {
                        return 0
                    }
                }
                '[' -> stack.push('[')
                ']' -> {
                    if (stack.isNotEmpty() && stack.peek() == '[') {
                        stack.pop()
                    } else {
                        return 0
                    }
                }
                '{' -> stack.push('{')
                '}' -> {
                    if (stack.isNotEmpty() && stack.peek() == '{') {
                        stack.pop()
                    } else {
                        return 0
                    }
                }
                else -> {
                    if (stack.isEmpty() || (stack.peek() != '(' && stack.peek() != '{' && stack.peek() != '[')) {
                        return 0
                    }
                }
            }
        }
        return if (stack.isEmpty()) {
            1
        } else {
            0
        }
    }

}

fun main() {
    // Good
    var testString = "{[()()]}"
    println(NestedString().nestedStringSolution2(testString))
    testString = "{[(dasfsdaf)(DSFsdafadsf)]}"
    println(NestedString().nestedStringSolution2(testString))
    testString = "{[()()]}"
    println(NestedString().nestedStringSolution2(testString))
    testString = "{[()()]}"
    println(NestedString().nestedStringSolution2(testString))

    // Bad
    println(NestedString().nestedStringSolution2("dsafasdfasdf"))
    testString = "{[()()]}adsfasdfadsf"
    println(NestedString().nestedStringSolution2(testString))
    testString = ")("
    println(NestedString().nestedStringSolution2(testString))
}
