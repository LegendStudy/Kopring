package lec18

fun main() {
    val fruits: List<Fruit> = listOf()
    val apples = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }

    val applePricesWithIndex = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice
        }

    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }

    val map: Map<String, List<Long>> = fruits
        .groupBy({ fruit -> fruit.name }, { fruit -> fruit.currentPrice })
    val map2: Map<Long, Long> = fruits
        .associateBy({fruit -> fruit.id}, { fruit -> fruit.currentPrice })
}