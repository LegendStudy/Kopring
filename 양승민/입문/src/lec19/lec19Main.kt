package lec19

import lec19.b.printHelloWorld as printHelloWorldB
import lec19.a.printHelloWorld as printHelloWorldA

fun main() {
    printHelloWorldA()
    printHelloWorldB()

    val person = Person("양승민", 100)
    val (name, age) = person

    val personComponent = Person("양승민", 100)
    val nameComponent = personComponent.component1()
    val ageComponent = personComponent.component2()
}

typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {

}

data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>


