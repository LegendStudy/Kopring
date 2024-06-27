fun main() {
    val number1 = 3
    val number2 = 4
}

fun printAgeIfPerson(obj: Any) {
    if(obj is Person) {
        println(obj.name)
    }
}