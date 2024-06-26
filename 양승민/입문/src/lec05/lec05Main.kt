package lec05

fun main() {

    val score = 100

    // 1. if문
    fun validateScoreIsNotNegative(score: Int) {
        if (score < 0) {
            throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
        }
    }

    // 2. Expression & Statement
    fun getPassOrFail(score: Int): String {
        return if (score >= 50) {
            "P"
        } else {
            "F"
        }
    }

    if (score in 0..100) {
        println("0~100")
    }

    // 3. Switch & When
    fun getGradeWithSwitch(score: Int): String {
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7 -> "C"
            else -> "D"
        }
    }

    fun getGradeWithSwitch2(score: Int): String {
        return when (score) {
            in 90..99 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "D"
        }
    }

    fun startsWithA(obj: Any): Boolean {
        return when (obj) {
            is String -> obj.startsWith("A")
            else -> false
        }
    }

    fun judgeNumber(number: Int) {
        return when (number) {
            1, 0, -1 -> println("어디서 많이 본 숫잔데?")
            else -> println("1, 0, -1이 아닙니다.")
        }
    }

    fun judgeNumber2(number: Int) {
        return when {
            number == 0 -> println("주어진 숫자는 0입니다")
            number %2 == 0-> println("주어진 숫자는 짝수입니다")
            else -> println("주어진 숫자는 홀수입니다")
        }
    }

}