class Person(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

fun main() {
    val person = Person("김아린", 100)
    val (name, age) = person
    println("이름 : ${name}, 나이 : ${age}")

    val numbers = listOf(1, 2, 3)
    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }

    for (number in numbers) {
        if (number == 2) {
            break
        }
    }

    numbers.forEach {number ->
        if (number == 2) {
            return@forEach
        }
    }

    abc@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@abc
            }
            println("${i} ${j}")
        }
    }
}