package lec01.kotlin

fun main() {
    var number1 = 10L   // 바꿀 수 있는 변수
    number1 = 5L

    val number2 = 10L   // 바꿀 수 없는 변수,
//    number2 = 9L Error !!

    val number3: Long
    number3 = 3L    // 최초 한 번 값 바인딩 가능

    val number4: Long
//    println(number4) // 초기화 되지 않았기 때문에 Error!

    var number5 = 10L
    var number6 = 1_000L

    // Kotlin이 연산을 할 때는 내부적으로 primitive type으로 바꾸고,
    // 그 외에는 Reference Type으로 사용한다.

    var number7: Long? = 1_000L
    // Kotlin에서는 기본적으로 null이 들어갈 수 없고
    // Kotlin에서 null이 변수에 들어갈 수 있다면 "타입?" 를 사용해야한다.
    number7 = null

    var person = Person("임준형")
    // Kotlin에서는 객체를 인스턴스화 할 때 new 키워드를 사용하지 않는다.

}