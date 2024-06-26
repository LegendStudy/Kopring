# 코틀린에서의 FP

## 15강 코틀린에서 배열과 컬렉션을 다루는 방법

### 불변 가변

Kotlin은 불변/가변을 지정해 주어야 함

Mutable이 Prefix면 가변, 없다면 불면

불변일 때 컬렉션 속 요소를 바꿀 수는 없음. 단 요소의 필드는 수정 가능. 

MutableList<Person>일 때 Person을 추가, 삭제는 할 수 있음. 단 MutableList<Person>.remove(0) 불가능

`listOf()` 메서드로 리스트를 만들 수 있으며 타입이 추론 가능함

컬렉션에서 `withIndex()` 메서드를 사용하면 인덱스 번호도 같이 갖고 옴

### 컬렌션의 null 가능성

`List<Int?>` : 리스트에 null 들어갈 수 있음, 리스트는 절대 null이 아님

`List<Int>?` : 리스트에 null 들어갈 수 없음, 리스트는 null일 수 있음

`List<Int?>?` : 리스트에 null이 들어갈 수 있고, 리스트가 null일 수 있음

`Java`와 `Kotlin`은 컬렉션에서 null 값을 다루는 과정이 다르기 때문에 방어 로직을 짜는게 좋음

## 코틀린에서 다양한 함수를 다루는 방법

### 확장함수

나오게된 배경

Java와 100% 호환성을 원함

기존 Java 코드 위에 자연스럽게 코틀린 코드를 추가할 수 없을까? 

Java로 만들어진 라이브러리를 유지보수, 확장할 때 Kotlin 코드를 덧붙이기 위해

어떤 클래스 안에 있는 메서드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 해보자

```kotlin
// String 클래스를 확장한 함수
fun String.lastChar(): Char {
    return this[this.length - 1]
}
```
위에서 this 는 String 클래스를 확장한 것이므로 String을 가리킴

String 클래스를 확장한 함수

만약 확장함수와 멤버함수의 메서드 이름이 같다면 멤버함수가 우선적으로 호출된다.

1. 확장함수는 원본 클래스의 Private, protected 멤버 접근이 되지 않음
2. 확장함수는 현재 타입을 기준으로 호출됨

Java에서는 Kotlin의 화강함수가 정적 메서드처럼 사용할 수 있음

### infix(중위) 함수

```kotlin
fun Int.add(other: Int): Int {
    return this + orther
}

infix fun Int.add2(other: Int): Int {
    return this + orther
}

class.add2 4 
위와 같이 사용 가능

```
### inline 함수
함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우'

### 지역함수

함수 안에 함수를 선언할 수 있음

하지만 depth가 깊어지고, 실무에서 잘안씀,  안쓰는게 좋음

## 17강 코틀린에서 람다를 다루는 방법

이름 없는 함수처럼 사용 가위는 

```kotlin
// 이름 없는 함수처럼 사용 가능, 원래는 fun isFruit()와 같음
val isApple = fun(fruit: Fruit):Boolean {
    return fru능it.name == "사과"
}

val isApple2 = { fruit: Fruit -> fruit.name == "사과"}
```

위는 반환 타입이 추론 가능하기 때문에 생략했지만 실제로는 
```kotlin
val isApple:(Fruit) -> Boolean = fun(fruit: Fruit):Boolean {
    return fruit.name == "사과"
}
```

이것과 같음. 

`Kotlin`은 함수를 파라미터로 바로 넣을 수 있음 

```kotlin
fun main() {
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    filterFruits(fruits, isApple)
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}
```

