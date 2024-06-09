package lec09

import java.lang.IllegalArgumentException

class Person(
    val name: String,
    var age: Int
) {

    val uppercaseName: String
        get() = this.name.uppercase()

    // 생성자가 호출되는 시점에 호출됨
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    constructor(name: String) : this(name, 3) {
        println("첫 번째 부 생성자")
    }

    constructor() : this("홍길동") {
        println("두 번째 부 생성자")
    }

    fun isAdult(): Boolean {
        return this.age >= 20
    }

    val isAdult: Boolean
    get() = this.age >= 20

}

fun main() {
    val person = Person("임준형", 100)
    println(person.name)
    person.age = 10
    println(person.age)

    val javaPerson = JavaPerson("임준형", 40)
    println(javaPerson.name)
    javaPerson.age = 10
    println(javaPerson.age)

    val person2 = Person("임준형")


}