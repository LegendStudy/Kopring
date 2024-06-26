package lec03

fun main() {

    // 1. 기본 타입
    val number1 = 3     // Int
    val number2 = 3L    // Long

    val number3 = 3.0f  // Float
    val number4 = 3.0   // Double

    // 명시적 변환
    val numberInt = 4
    val numberLong = numberInt.toLong()

    // 추가 예시
    val numberInt2 = 3
    val numberInt3 = 5
    val result = numberInt2 / numberInt3.toDouble()

    // 2. 타입 캐스팅
    fun printAgeIfPerson(obj: Any) {
        if(obj is Person) {
            val person = obj as Person
            println(person.age)
        }
    }

    // 개선
    fun printAgeIfPersonForSmart(obj: Any) {
        if(obj is Person) {
            println(obj.age)
        }
    }

    // 4-1. String Interpolation
    val person = Person("양승민", 100)
    val log = "사람의 이름은 ${person.name}이고 나이는 ${person.age}세 입니다"


    // 4-2. String Indexing
    val str = "ABCDE"
    val ch = str[1]

}