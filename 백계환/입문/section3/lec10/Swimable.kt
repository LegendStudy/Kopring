package section3.lec10

interface Swimable {

    val swimAbility: Int
        get() = 3

    fun act(){
        println("어푸 어푸")
    }
}
