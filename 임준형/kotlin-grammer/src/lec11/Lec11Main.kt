package lec11

class Lec11Main {
    fun main() {
        isDirectoryPath("/")
    }
}

class Car(
    val name: String,
    var owner: String,
    _price: Int
    ) {
    var price = _price
        private set

}