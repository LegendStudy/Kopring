fun main() {
    val people = listOf(
        Person("짱구", 1),
        Person("훈이", 1),
        Person("맹구", 1),
        Person("철수", 1),
        Person("유리", 1),
        Person("짱구", 1),
    )

    val isRed: (Person) -> Boolean = fun(person: Person): Boolean {
        return person.name == "짱구"
    }

    val isRed2: (Person) -> Boolean = { person: Person -> person.name == "짱구" }
    isRed(people[0])
    isRed.invoke(people[2])


    filterPeople(people, isRed)
}

private fun filterPeople(people: List<Person>, filter: (Person) -> Boolean):
        List<Person> {
    val results = mutableListOf<Person>()
    for (person in people) {
        if (filter(person)) {
            results.add(person)
        }
    }
    return results
}