package lec19

class PersonNotData (
    val name: String,
    val age: Int
){
    operator fun component1() = name
    operator fun component2() = age
}