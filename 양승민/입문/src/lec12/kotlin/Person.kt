package lec12.kotlin

class Person private constructor(
    private val name:String,
    private val age:Int,
) {
    companion object{
        private const val MIN_AGE = 0

        @JvmStatic
        fun newBaby(name: String) = Person(name, MIN_AGE)
    }
}