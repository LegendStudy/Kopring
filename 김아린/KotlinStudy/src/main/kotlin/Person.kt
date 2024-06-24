import java.lang.IllegalArgumentException

fun main() {
    Person()
}

class Person constructor(
    val name: String = "김아린",
    var age: Int = 1
) {
    val uppercaseName: String
        get() = this.name.uppercase()

    init {
        if (age < 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("초기화")
    }

}