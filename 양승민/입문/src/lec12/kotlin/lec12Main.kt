package lec12.kotlin

import lec12.java.Movable

fun main() {
    moveSomething(object : Movable {
        override fun move() {
            println("움직움직")
        }

        override fun fly() {
            println("날앙")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}