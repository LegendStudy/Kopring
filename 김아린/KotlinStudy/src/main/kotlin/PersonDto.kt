fun main() {
    val dto1 = PersonDto("김아린", 100)
    val dto2 = PersonDto("김아린", 100)
    println(dto1 == dto2)
}

data class PersonDto(
    val name: String,
    val age: Int,
)