package lec01

fun main() {

    // 1. 변수 선언 키워드: var과 val의 차이점
    var number1: Long = 10L
    val number2: Long = 10L

    // 2. Kotlin에서의 기본형 타입
    var number3: Long = 1_000L

    // ++ Kotlin에서의 컬렉션
    val numbers = ArrayList<Int>()

    // 3. Kotlin에서의 nullable 변수
    var number4: Long? = null

    // 4. Kotlin에서의 객체 인스턴스화
    var person = Person("양승민")

}