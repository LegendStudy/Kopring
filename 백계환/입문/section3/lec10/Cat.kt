package section3.lec10

class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("꽁꽁 얼어붙은 한강 위로 고양이가 걸어 다닙니다.")
    }
}
