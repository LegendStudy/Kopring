package lec15

fun main() {
    val array = arrayOf(100, 200)

    // indices는 0부터 마지막 index까지의 범위
    for (i in array.indices) {
        println("${i}, ${array[i]}")
    }

    // withIndex()를 사용하면, 인덱스와 값을 한 번에 가져올 수 있음
    for ((idx, value) in array.withIndex()) {
        println("$idx: $value")
    }

    // 배열에 값 넣기
    array.plus(300)

    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>()

    useNumbers(emptyList())

    // 하나를 가져오기
    println(numbers[0])

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문 느낌
    for((index, value) in numbers.withIndex()) {
        println("$index: $value")
    }

    // 가변 리스트 만들기
    val mutableNumbers = mutableListOf(100, 200)
    mutableNumbers.add(300)

    val map = mutableMapOf<Int, String>()
    map[1] = "MONDAY"
    map[2] = "TUESDAY"

    mapOf(1 to "MONDAY", 2 to "TUESDAY")

}

private fun useNumbers(numbers: List<Int>) {
    // TODO
}