---
​
이번 포스트에서는 코틀린을 배우는 과정에서 컬렉션, 확장 함수, 함수형 프로그래밍, 스코프 함수에 대해 코틀린에서 이들을 다루는 방법에 대해 자세히 살펴보겠습니다.
​
### 1\. 컬렉션 (Collections)
​
코틀린에서는 컬렉션을 만들 때 불변/가변을 지정해야 합니다. List, Set, Map에 대한 사용법이 변경되고 확장되었습니다. 자바와 코틀린 코드를 섞어 사용할 때 주의해야 합니다.
​
-   **불변 컬렉션:**
-   `val immutableList = listOf(1, 2, 3)`
-   **가변 컬렉션:**
-   `val mutableList = mutableListOf(1, 2, 3) mutableList.add(4)`
-   **자바와 코틀린 컬렉션 사용 시 주의사항:**
    -   자바에서 코틀린 컬렉션을 가져갈 때는 불변 컬렉션을 수정할 수 있고, non-nullable 컬렉션에 null을 넣을 수도 있습니다.
    -   코틀린에서 자바 컬렉션을 가져갈 때는 플랫폼 타입을 주의해야 합니다.
​
### 2\. 확장 함수와 확장 프로퍼티
​
코틀린에서는 자바 코드가 있는 상황에서 추가 기능을 개발하기 위해 확장 함수와 확장 프로퍼티가 등장했습니다.
​
-   **확장 함수 예제:**
-   `fun String.lastChar(): Char = this[this.length - 1] println("Kotlin".lastChar()) // Output: n`
-   **확장 함수의 제한사항:**
    -   확장 함수는 원본 클래스의 private, protected 멤버에 접근할 수 없습니다.
    -   멤버 함수와 확장 함수 중 멤버 함수에 우선권이 있습니다.
    -   확장 함수는 현재 타입을 기준으로 호출됩니다.
    -   자바에서는 static 함수를 사용하는 것처럼 코틀린의 확장 함수를 사용할 수 있습니다.
​
### 3\. 함수형 프로그래밍
​
코틀린에서는 함수형 프로그래밍을 지원하며, 함수는 1급 시민으로 취급됩니다. 함수 자체를 변수에 넣거나 파라미터로 전달할 수 있습니다.
​
-   **함수 타입:**
-   `val sum: (Int, Int) -> Int = { x, y -> x + y }`
-   **람다 표현식:**
-   `val sum = { x: Int, y: Int -> x + y }`
-   **마지막 파라미터인 람다를 소괄호 밖으로 뺄 수 있음:**
-   `val list = listOf(1, 2, 3, 4, 5) list.filter { it % 2 == 0 }`
-   **클로저를 사용하여 non-final 변수도 람다에서 사용 가능:**
-   `var sum = 0 list.forEach { sum += it }`
​
### 4\. 컬렉션의 함수형 처리
​
코틀린에서는 컬렉션을 함수형으로 다룰 수 있습니다.
​
-   **함수형 처리 예제:**
-   `val numbers = listOf(1, 2, 3, 4, 5) val evens = numbers.filter { it % 2 == 0 } val doubled = numbers.map { it * 2 }`
-   **자주 사용되는 컬렉션 함수:**
    -   `filter`, `filterIndexed`
    -   `map`, `mapIndexed`, `mapNotNull`
    -   `all`, `none`, `any`
    -   `count`, `sortedBy`, `sortedByDescending`, `distinct`
    -   `first`, `firstOrNull`, `last`, `lastOrNull`
    -   `groupBy`, `associateBy`
    -   `flatMap`, `flatten`
​
### 5\. 스코프 함수 (Scope Functions)
​
코틀린의 스코프 함수는 일시적인 영역을 만들어 코드를 더 간결하게 하거나, 메서드 체인에 활용할 수 있습니다. 스코프 함수에는 `let`, `run`, `also`, `apply`, `with`가 있습니다.
​
-   **스코프 함수 예제:**
-   `val person = Person("John", 30) // let person.let { println(it.name) } // run person.run { println(name) } // also person.also { println(it.name) } // apply person.apply { name = "Doe" } // with with(person) { println(name) }`
​
스코프 함수는 코드의 가독성을 높이는 데 도움을 주지만, 팀 내에서 일관된 사용을 위해 컨벤션을 정하는 것이 중요합니다.
​
---
