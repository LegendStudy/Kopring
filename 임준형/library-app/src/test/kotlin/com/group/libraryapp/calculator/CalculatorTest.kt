package com.group.libraryapp.calculator

import com.group.libraryapp.caculator.Calculator

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
}

class CalculatorTest {

    fun addTest() {
        val calculator = Calculator(5)
        calculator.add(3)

        val expectedCalculator = Calculator(8)
        if (calculator != expectedCalculator) {
            throw IllegalStateException()
        }
    }

    fun minusTest() {
        val calculator = Calculator(5)
        calculator.minus(3)

        val expectedCalculator = Calculator(2)
        if (calculator != expectedCalculator) {
            throw IllegalStateException()
        }
    }

    fun multiplyTest() {
        val calculator = Calculator(5)
        calculator.multiply(3)

        val expectedCalculator = Calculator(15)
        if (calculator != expectedCalculator) {
            throw IllegalStateException()
        }
    }
}