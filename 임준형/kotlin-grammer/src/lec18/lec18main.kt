package lec18

import lec17.Fruit


private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {

    // 파라미터로 받은 함수 그대로 사용 가능
    fruits.filter(filter)
    val map = fruits.map { fruit -> fruit.price }

    fruits.all {fruit -> fruit.name == "사과" }
    fruits.none {fruit -> fruit.name == "사과" }
    fruits.any {fruit -> fruit.name == "사과" }
    fruits.sortedBy { fruit: Fruit -> fruit.price }

}

