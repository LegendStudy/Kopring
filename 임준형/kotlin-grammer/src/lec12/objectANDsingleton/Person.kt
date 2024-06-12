package lec12.objectANDsingleton

class Person private constructor(
    private var name: String,
    private var age: Int
) {

    // static 대신 companion object 사용
    // const 작성시 컴파일 시에 값이 들어감. 정말 진짜 상수
    // val 작성시 런타임 시에 값이 들어감.
    companion object Factory : Log {
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스 동행 객체에요")
        }
    }
}

// 외부에서 바로 접근 가능
object Singleton {
    var a:Int = 0
}