package lec09

fun main() {

    // 1. 클래스와 프로퍼티
    val person = Person("양승민", 100)
    println(person.name)
    person.age = 10

    println(person.age)

    val javaPerson = Person("양승민", 100)
    println(javaPerson.name)
    javaPerson.age = 10

    println(javaPerson.age)
}
