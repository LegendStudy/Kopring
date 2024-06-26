package section3.lec09

import java.lang.IllegalArgumentException

fun main() {
    val person = Person("jacob", 26)
    println(person.name)
    person.age = 10
    println(person.age)
    println(person.upperCase)
    println(person.isAdult())
}

class Person(
    val name: String = "백계환",
    var age: Int = 26
) {
//    val name = name
//        get() = field.uppercase()

//    fun getUpperCase(): String = this.name.uppercase()

    val upperCase: String
        get() = this.name.uppercase()

    // init(초기화) 블록은 생성자가 호출되는 시점에 호출된다.
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    constructor(name: String) : this(name, 1)

    fun isAdult(): Boolean {
        return this.age >= 20
    }
//    val isAdult: Boolean
//        get() = this.age >= 20
}

