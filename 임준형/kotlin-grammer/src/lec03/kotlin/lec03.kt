package lec03.kotlin

import lec02.java.Person

fun main() {

}

fun typeTrans() {
    val number1 = 3
    val number2: Long = number1.toLong()

    val number3: Int? = 3
    val number4: Long = number1.toLong() ?: 0L  // null일 경우 0L 삽입
}

fun printAgeIfPerson1(obj: Any) {
    if (obj is Person) {
        val person = obj // as Person // 생략 가능, '스마트 캐스트'
        println(person.age)
    }
}

fun printAgeIfPerson2(obj: Any?) {  // Null이 들어오면 NPE 발생, as에 ? 사용
    val person = obj as? Person
    println(person?.age)
}

fun stringInstead() {
    val person = Person("임준형", 25)
    System.out.println(String.format("이름 : %s", person.name))

    println("이름 : ${person.name}")
//    println("이름 : $person.name") 객체타입으로 나옴
    val name = person.name
    println("이름 : $name")   // 중괄호 생략 가능
}

fun stringTrimIndent() {
    val str = """
       ABCD
    """.trimIndent()
    println(str)
}

fun pickStringIndex() {
    val str = "ABC"

    val a = str[0]
    val b = str[1]
    val c = str[2]

    println("a = $a")
    println("b = ${b}")
    println("c = ${c}")
}