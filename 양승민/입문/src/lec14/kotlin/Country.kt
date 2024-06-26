package lec14.kotlin

enum class Country(
    val code: String,
) {
    KOREA("KO"),
    AMERICA("US");

    private fun handleCountry(country: Country) {
        when (country) {
            KOREA -> TODO()
            AMERICA -> TODO()
        }
    }
}