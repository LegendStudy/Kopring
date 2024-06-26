package lec09

// 1. 클래스와 프로퍼티
class Person(
    name: String = "양승민",
    var age: Int = 1
) {

    var name: String = name
        get() = field.uppercase()
        set(value){
            field = value.uppercase()
        }

    // 2. 생성자와 init
    init {
        if (age < 0) {
            throw IllegalArgumentException("나이(${age})가 이상함")
        }
    }

    constructor(name: String) : this(name, 1) {
        println("부생성자 1")
    }

    constructor() : this("양승민") {
        println("부생성자 2")
    }

    // 3. 커스텀 getter, setter
    fun isAdultV1(): Boolean {
        return this.age >= 20
    }

    val isAdultV2: Boolean
        get() = this.age >= 20

    val isAdultV3: Boolean
        get() {
            return this.age >= 20
        }

}