package lec10.kotlin

class Cat(
    species: String
) : Animal(species, 4) {
    override fun move() {
        println("꽁꽁 얼어붙은 한강위로 고양이가 걸어다닙니다.")
    }
}