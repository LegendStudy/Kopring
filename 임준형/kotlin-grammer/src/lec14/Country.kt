package lec14

import lec14.Country.*

fun handleCountry(country: Country) {
    when (country) {
        KOREA -> TODO()
        AMERICA -> TODO()
    }
}

enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US")
}