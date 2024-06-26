package lec14.kotlin

sealed class HyundaiCar(
    val name: String,
    val price: Long
) {

    class Avante : HyundaiCar("아반떼", 1_000L)

    class Sonata : HyundaiCar("소나타", 2_000L)

    class Grandeur : HyundaiCar("그렌저", 3_000L)

}