# [Section 5] 추가적으로 알아두어야 할 특성

# ✅ 코틀린 이모저모

## 🔖 Type Alias와 as import

```kotlin
typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {

}
```

다음 처럼 함수형 타입의 별명을 지어줄 수 있다.

```kotlin
data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>
```

이름이 긴 클래스를 컬렉션에 사용할 때도 간단히 줄일 수 있다.

다른 패키지의 같은 이름 함수를 동시에 가져올 경우 `as Import`를 사용하여 가져올 수 있다.

```kotlin
import lec19.b.printHelloWorld as printHelloWorldB
import lec19.a.printHelloWorld as printHelloWorldA

fun main() {
    printHelloWorldA()
    printHelloWorldB()
}
```

---

## 🔖 구조분해와 componentN 함수

> **복합적인 값을 분해하여 여러 변수를 한 번에 초기화하는 것**을 의미한다.
> 

`Data Class`는 `componentN`이란 함수도 자동으로 만들어준다.

```kotlin
    val person = Person("양승민", 100)
    val (name, age) = person

		// 위랑 같은 코드임
    val personComponent = Person("양승민", 100)
    val nameComponent = personComponent.component1()
    val ageComponent = personComponent.component2()
```

`Data Class`가 아니라면 직접 구현해 줄 수도 있다.

```kotlin
class PersonNotData (
    val name: String,
    val age: Int
){
    operator fun component1() = name
    operator fun component2() = age
}
```

---

## 🔖 TakeIf와 TakeUnless

### ✒️ TakeIf

> 주어진 조건을 만족하면 그 값이, 그렇지 않으면 `null` 반환
> 

### ✒️ TakeUnless

> 주어진 조건을 만족하지 못하면 그값이, 그렇지 않으면 `null` 반환
> 

---