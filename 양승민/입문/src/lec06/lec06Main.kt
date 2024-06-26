package lec06

fun main() {

    // 1. for each 문
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }

    // 2. 전통적인 for 문
    for (i in 1..3) {
        println(i)
    }
    for (i in 3 downTo 1) {
        println(i)
    }
    for (i in 1..5 step 2) {
        println(i)
    }

}