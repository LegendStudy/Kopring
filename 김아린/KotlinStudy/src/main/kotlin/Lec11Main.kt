val NUM = 3

fun add(a: Int, b: Int): Int {
    return a + b
}

open class Dog protected constructor(

)


class Car(
    internal val name: String,
    private  var owner: String,
    _price: Int
) {
    var price = _price
        private set
}