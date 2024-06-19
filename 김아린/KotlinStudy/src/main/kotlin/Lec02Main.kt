fun main() {
    val str: String? = null
    println(str?.length ?: 0)

    val person = Person("공부하는 개발자")
    startsWithA(person.name)
}

fun startWithA1(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 입력되었습니다")
}

fun startWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startWith(str: String?): Boolean {
    return str!!.startsWith("A")
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}