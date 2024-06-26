package lec16

fun main() {
    val str = "ABC"
    str.lastChar()

    3 add 2
}

fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

infix fun Int.add(other: Int): Int {
    return this + other
}

inline fun Int.minus(other: Int): Int {
    return this - other
}