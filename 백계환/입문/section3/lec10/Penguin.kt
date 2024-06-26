package section3.lec10

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingcount: Int = 2

    override fun move() {
        println("펭귄이 움직인다.")
    }

    override val legCount: Int
        get() = super.legCount + this.wingcount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }
}
