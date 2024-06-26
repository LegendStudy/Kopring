package section1.lec02

import java.lang.IllegalArgumentException

fun main() {
    val str: String? = null
    println(str?.length ?: 3)
    println(startWithA("ABC"))
}

fun startsWithA1(str: String?): Boolean {
//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다.")
//    }
//    return str.startsWith("A")
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startWithA2(str: String?): Boolean? {
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")
    return str?.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")
    return str?.startsWith("A") ?: false
}

fun startWithA(str: String?): Boolean {
    return str!!.startsWith("A")
}
