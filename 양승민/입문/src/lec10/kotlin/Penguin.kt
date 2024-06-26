package lec10.kotlin

class Penguin(
    species: String,
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount = 2
    override fun move() {
        println("가자 펭귄")
    }

    override val legCount
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }
}