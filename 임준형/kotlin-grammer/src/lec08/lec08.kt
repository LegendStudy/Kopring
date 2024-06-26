package lec08

// 반환 값이 추론 가능하므로 생략이 가능함
fun max(a: Int, b: Int) = if (a > b) a else b

fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

fun printAll(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}

fun main() {
    repeat("Hello", 1, true)
    repeat("Hello", useNewLine = false)

    printNameAndGender(gender = "MALE", name = "임준형") // 실수로 순서를 바꿔버리는 경우
    // Lec08Main.repeat(str = "A") Java 함수를 사용할 때 named argument를 사용할 수 없음

    printAll("A", "B", "C")

    val array = arrayOf("a", "b", "c")
    printAll(*array)
}