package lec03

import section1.lec03.Person


fun main() {
    val number1 = 3
    val number2: Long = number1.toLong()

    // 변수가 nullable이라면 적절한 처리가 필요하다.
    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0L

    printAgeIfPerson(Person("", 26))
    printAgeIfPerson(null)

    val person = Person("백계환", 100)
    println("이름: ${person.name}")

    val str = """
        ABC
        DEF
        ${person.age}
    """.trimIndent()
    print(str)
}

fun printAgeIfPerson(obj: Any?) {
    if (obj is Person) {
        println(obj.age) // 스마트캐스트
    }
    val person = obj as? Person
    println(person?.age)
}
