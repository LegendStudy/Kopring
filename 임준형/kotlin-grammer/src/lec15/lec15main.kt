package lec15

fun main() {

    kotlinCollection()

    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MonDay"
    oldMap[2] = "TUESDAY"

    mapOf(1 to "Monday", 2 to "TUESDAY")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

private fun kotlinCollection() {
    val numbers = listOf(100, 200)

    val emptyList = emptyList<Int>()
    val emptyList2 = printNumbers(emptyList())  // 타입이 정해져있는 것을 사용하면 추론 가능함

    // 아래 둘은 같은 코드
    val sameNum2 = numbers.get(0)
    val num2 = numbers[0]

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("${idx} ${value}")
    }
}

private fun printNumbers(numbers: List<Int>) {
}