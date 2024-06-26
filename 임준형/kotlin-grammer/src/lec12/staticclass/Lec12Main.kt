package lec12.staticclass

import lec12.objectANDsingleton.Person

fun main() {
    moveSomething(object : Moveable {
        override fun move() {
            println("움직인다")
        }

        override fun fly() {
            println("난다")
        }
    })

    Person.newBaby("hello")
}

private fun moveSomething(moveable: Moveable) {
    moveable.move()
    moveable.fly()
}