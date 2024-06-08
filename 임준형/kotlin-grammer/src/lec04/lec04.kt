package lec04

fun main() {
    val money1 = JavaMoney(2_000L)
    val money2 = money1;
    val money3 = JavaMoney(2_000L)

    if (money1 > money2) {  // 자동으로 compare 호출
        println("Money1이 Money2보다 금액이 큽니다.")
    }

    println(money1 === money2)  // true
    println(money1 == money3)  // true, 단 equals 오버라이딩이 적용되어있을때
}