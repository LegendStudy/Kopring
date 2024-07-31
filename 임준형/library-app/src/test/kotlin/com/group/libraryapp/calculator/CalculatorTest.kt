package com.group.libraryapp.calculator

import com.group.libraryapp.caculator.Calculator
import java.lang.Exception
import java.lang.IllegalArgumentException

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
    calculatorTest.divideExceptionTest()
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

    fun divideTest() {
        val calculator = Calculator(5)
        calculator.divide(2)

        val expectedCalculator = Calculator(2)
        if (calculator != expectedCalculator) {
            throw IllegalStateException()
        }
    }

    fun divideExceptionTest() {
        val calculator = Calculator(5)

        try {
            calculator.divide(0)
        } catch (e: IllegalArgumentException) {
            // 테스트 성공!
            return
        } catch (e: Exception) {
            throw IllegalStateException()
        }
        throw IllegalStateException("기대하는 예외가 발생하지 않았습니다.")
    }
}