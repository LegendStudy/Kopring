package lec14

fun main() {
    val dto1 = PersonDto("임준형", 100)
    val dto2 = PersonDto("임준형", 200)
    val dto3 = PersonDto("임준형", 200)
    println(dto1 == dto2)
    println(dto2 == dto3)
    println(dto3)
}

data class PersonDto(
    val name: String,
    val age: Int
) {
}