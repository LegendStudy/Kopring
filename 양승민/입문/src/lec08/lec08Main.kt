package lec08

fun main() {

    // 1. 함수 선언 문법
    fun max(a: Int, b: Int) = if (a > b) a else b

    // 2. default parameter
    fun repeat(
        str: String,
        num: Int = 3,
        useNewLine: Boolean = true
    ) {
        for (i in 1..num) {
            if (useNewLine) {
                println(str)
            } else {
                print(str)
            }
        }
    }

    // 3. named argument
    repeat("Hello world!", useNewLine = false)

    // 4. 같은 타입의 여러 파라미터 받기 (가변인자)
    fun printAll(vararg strings: String) {
        for (str in strings) {
            println(str)
        }
    }

    val array = arrayOf("A", "B", "C")
    printAll(*array)

    printAll("A", "B", "C")

}