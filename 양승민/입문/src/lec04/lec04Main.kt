package lec04

fun main() {

    // 1. 비교 연산자
    val a = 5;
    val b = 5;

    if (a === b) {
        println("동일성 비교")
    } else if (a == b) {
        println("동등성 비교")
    }

    // 2. in 연산자
    val str = "ABCDE"
    if ('B' in str) {
        println("str 안에 B 있음")
    }
    if ('H' !in str) {
        println("str 안에 H 없음")
    }

    // 3. 연산자 오버로딩
    val money1 = Money(1_000L)
    val money2 = Money(2_000L)
    println(money1 + money2)
}