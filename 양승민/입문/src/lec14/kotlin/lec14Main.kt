package lec14.kotlin

fun main() {
    handleCar(HyundaiCar.Avante())
}

private fun handleCar(car: HyundaiCar) {
    when (car) {
        is HyundaiCar.Avante -> TODO()
        is HyundaiCar.Sonata -> TODO()
        is HyundaiCar.Grandeur -> TODO()
    }
}