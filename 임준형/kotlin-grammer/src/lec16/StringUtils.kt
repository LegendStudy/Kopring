package lec16

fun main() {
    확장함수1()

    val person = JavaPerson("A", "B", 100)
    person.nextYearAge()
}

private fun 확장함수1() {
    val str = "ABC"
    println(str.lastChar())
}

fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun JavaPerson.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}