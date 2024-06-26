package lec02

fun main() {

    // 1. Kotlin에서의 null 체크
    // Exception을 내거나
    fun startsWithA1(str: String?): Boolean {
        if (str == null) {
            throw IllegalAccessException("null이 들어왔습니다.")
        }
        return str.startsWith("A")
    }

    // null을 반환하거나
    fun startsWithA2(str: String?): Boolean? {
        if (str == null) {
            return null
        }
        return str.startsWith("A")
    }

    // false를 반환하거나
    fun startsWithA3(str: String?): Boolean {
        if (str == null) {
            return false
        }
        return str.startsWith("A")
    }

    // 2. Safe Call과 Elvis 연산자
    val str: String? = "ABC"

    // Safe Call
    str.length  // 불가능
    str?.length // 가능

    // Elvis 연산자
    str?.length ?: 0

    // 위 함수에 적용하면?
    fun startsWithA1V2(str: String?): Boolean {
        return str?.startsWith("A")
            ?: throw IllegalAccessException("null이 들어왔습니다.")
    }

    fun startsWithA2V2(str: String?): Boolean? {
        return str?.startsWith("A")
    }

    fun startsWithA3V2(str: String?): Boolean {
        return str?.startsWith("A") ?: false
    }

    // early return
    fun calculate(number: Long?): Long {
        number ?: return 0
        //다음 로직
    }

    // null 아님 단언
    fun startsWithA4(str: String?): Boolean {
        return str!!.startsWith("A")
    }

}