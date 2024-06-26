package lec02.kotlin

import lec02.java.Person

fun main() {
//    val str: String? = "ABC"
//    println(str?.length)

    val person = Person("공부하는 개발자")
    startsWithA(person.name)
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1Kotlin(str: String?): Boolean {   // java 1번과 대응
    /*
    safe call
     */
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA1JavaStyle(str: String?): Boolean {
    /*
    java style
     */
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다.")
    }
    return str.startsWith("A")
}

fun startsWithA2Kotlin(str: String?): Boolean? {  // java 2번과 대응
    return str?.startsWith("A")
}

fun startsWithA2JavaStyle(str: String?): Boolean? {  // java 2번과 대응
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startsWithA3Kotlin(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

// input - null 일 수도 있는 String, return - null이 아닌 Boolean
fun startsWithA3JavaStyle(str: String?): Boolean {
//    str.startsWith("A")
//    불가능, 애초에 String이 아닌 null일 수 있는 String? 타입으로 선언했으므로 null 체크를 해야만 사용 가능
    if (str == null) {
        return false;
    }
    return str.startsWith("A")
}

fun startsWith(str: String?): Boolean {
    /**
     * Nullable 타입이 들어오지만 어떤 경우에도 Null이 아닐 경우
     */
    return str!!.startsWith("A")
}