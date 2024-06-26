package lec10.kotlin

class Penguin (
    species: String
) : Animal(species, 2), Flyable, Swimable {

    private val wingCount: Int = 2

    override fun move() {
        println("꽁꽁 얼어붙은 한강 위로 팽귄이 꿱꿱~!")
    }

    override val legCount: Int
        get() = super.legCount + wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

}