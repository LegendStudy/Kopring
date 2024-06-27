fun main() {

    mutableListOf("one", "two", "three")
        .also { println("The list elements before adding new one: $it") }
        .add("four")

    val numbers = mutableListOf("one", "two", "three")
    println("The list element before adding new one: $numbers")
}

fun printPerson(person: Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }
}