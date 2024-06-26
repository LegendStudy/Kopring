package lec17

import java.io.BufferedReader
import java.io.FileReader

fun main() {
    // 람다를 만드는 방법 1
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // 람다를 만드는 방법 2
    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    // 람다를 직접 호출하는 방법 1
    isApple(Fruit("사과", 1000))

    // 람다를 직접 호출하는 방법 2
    isApple.invoke(Fruit("사과", 1000))

    val fruits = listOf(Fruit("사과", 1000))

    filterFruits(fruits, isApple)
}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for(fruit in fruits) {
        if (filter.invoke(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader -> println(reader.readLine()) }
}