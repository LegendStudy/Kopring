# [Section 4] FP

# ✅ 코틀린에서 `배열과 컬렉션`을 다루는 방법

## 🔖 배열

배열 자체를 잘 안쓰긴 함

그래도 대충 알고 가자.

```kotlin
    val array = arrayOf(100, 200)

    // indices는 0부터 마지막 index까지의 범위
    for (i in array.indices) {
        println("${i}, ${array[i]}")
    }
    
    // withIndex()를 사용하면, 인덱스와 값을 한 번에 가져올 수 있음
    for((idx, value) in array.withIndex()) {
        println("$idx: $value")
    }
    
    // 배열에 값 넣기
    array.plus(300)
```

---

## 🔖 Collection - List, Set, Map

### ✒️ 가변 컬렉션

> 컬렉션에 요소를 추가, 삭제할 수 있다.
> 

### ✒️ 불변 컬렉션

> 컬렉션에 요소를 추가, 삭제할 수 없다.
불변 컬렉션이라도 참조 타입의 요소 필드는 바꿀 수 있다.
> 

### ✒️ List

```java
final List<Integer> numbers = Arrays.asList(100, 200);
```

```kotlin
val numbers = listOf(100, 200)
val emptyList = emptyList<Int>()
```

```kotlin
fun main() {
		// 타입을 추론할 수 있다면 생략 가능
    useNumbers(emptyList())
}

private fun useNumbers(numbers: List<Int>) {
    // TODO
}
```

```java
        // 하나를 가져오기
        System.out.println(numbers.get(0));

        // For Each
        for (int number : numbers) {
            System.out.println(number);
        }

        // 전통적인 For문
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%s, %s", i, numbers.get(i));
        }
```

```kotlin
    // 하나를 가져오기
    println(numbers[0])

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문 느낌
    for((index, value) in numbers.withIndex()) {
        println("$index: $value")
    }
```

```kotlin
    // 가변 리스트 만들기
    val mutableNumbers = mutableListOf(100, 200)
    mutableNumbers.add(300)
```

**우선 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 바꾸자.**

### ✒️ Set

List와 똑같다.

### ✒️ Map

```java
        // JDK 8까지
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "MONDAY");
        map.put(2, "TUESDAY");

        // JDK 9부터
        Map.of(1, "Monday", 2, "TUESDAY");
```

```kotlin
    // 타입 추론이 불가능하여 타입을 지정
    val map = mutableMapOf<Int, String>()
    
    // 가변 Map 이기 때문에 (key, value)를 넣을 수 있음
    map[1] = "MONDAY"
    map[2] = "TUESDAY"

		// 불변 map
    mapOf(1 to "MONDAY", 2 to "TUESDAY")
```

---

## 🔖 null 가능성, Java와 함께 사용하기

### ✒️ 컬렉션<타입?>

> 컬렉션에 `null`이 들어갈 수 있지만, 컬렉션은 절대 `null`이 아님
> 

### ✒️ 컬렉션<타입>?

> 컬렉션에 `null`이 들어갈 수 없지만, 컬렉션은 `null`일 수 있음
> 

### ✒️ 컬렉션<타입?>?

> 컬렉션에 `null`이 들어갈 수도 있고, 컬렉션이 `null`일 수도 있음
> 

자바는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않는다.

따라서 **코틀린 쪽의 컬렉션이 자바에 호출되면 컬렉션 내용이 변할 수 있다.**

코틀린 쪽에서 `Collections.unmodifableXXX()`를 활용하여 변경을 막을 수 있다.

---

# ✅ 코틀린에서 `다양한 함수`를 다루는 방법

## 🔖 확장함수

코틀린은 자바와 100% 호환하는 것을 목표로 한다고 한다.

따라서 기존 자바 코드 위에 자연스럽게 코틀린 코드를 추가할 수는 없을까?

```kotlin
fun main() {
    val str= "ABC"
    str.lastChar()
}

fun String.lastChar(): Char {
    return this[this.length - 1]
}
```

위처럼 기존의 클래스의 함수를 확장하여 사용 가능하다.

만약 멤버함수와 확장함수의 시그니처가 같다면?

```java
public class Person {

    private final String firstName;
    private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int nextYearAge() {
        System.out.println("멤버 함수");
        return this.age + 1;
    }

    public int getAge() {
        return age;
    }
}
```

```kotlin
fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}
```

멤버함수가 우선적으로 호출된다.

확장함수가 오버라이드 된다면 해당 변수의 현재 타입
즉, **정적인 타입에 의해 어떤 확장함수가 호출될지 결정**된다.

자바에서도 코틀린의 확장함수를 가져다 정적 메소드를 부르는 것처럼 사용 가능하다.

**확장 프로퍼티 = 확장함수 + `custom getter`**

---

## 🔖 infix 함수

`downTo`, `step` 같은 함수가 중위 호출 함수이다.

```kotlin
fun main() {
    3 add 2
}

infix fun Int.add(other: Int): Int {
    return this + other
}
```

---

## 🔖 inline 함수

> 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 넣는 함수이다.
> 

```kotlin
inline fun Int.minus(other: Int): Int {
    return this - other
}
```

---

## 🔖 지역 함수

함수로 추출하면 좋을 것 같은데, 함수를 함수 내에서만 사용하고 싶을 때 사용한다.
근데 비추임 `depth`가 깊어지기도 하고 코드가 별로다.

---

# ✅ 코틀린에서 `람다`를 다루는 방법

## 🔖 자바에서 람다를 다루기 위한 노력

처음에는 **익명 클래스**를 씀 → 복잡함

JDK8부터 **람다가 등장**해서 `Predicate`, `Consumer` 등 인터페이스가 많이 생겼다.

**간결한 스트림이 등장**해서 병렬처리도 쉽게 가능해졌다.

후에는 **메소드 레퍼런스**로 단일 파라미터 함수처리가 더 간결해졌다.

---

## 🔖 코틀린에서의 람다

이렇게 똥꼬쇼 했지만, 자바와는 근본적으로 코틀린은 함수 자체를 값으로 쓸수 있기 때문에 변수에 할당할 수도, 파라미터로 넘길 수도 있다.

```kotlin
    // 람다를 만드는 방법 1
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // 람다를 만드는 방법 2
    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    // 람다를 직접 호출하는 방법 1
    isApple(Fruit("사과", 1000))

    // 람다를 직접 호출하는 방법 2
    isApple.invoke(Fruit("사과", 1000))
```

**`함수의 타입 : (파라미터 타입…) → 반환 타입`**

```kotlin
fun main() {
    val fruits = listOf(Fruit("사과", 1000))

    filterFruits(fruits, isApple)
}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for(fruit in fruits) {
        if (filter.invoke(fruit)) {
            results.add(fruit)
        }
    }
    return results
}
```

코틀린에서는 함수가 1급 시민이다. (자바에서는 2급 시민)

마지막 파라미터가 함수인 경우, **소괄호 밖에 람다로 사용 가능**하다.
람다를 작성할 때, 람다의 파라미터를 `it`으로 직접 참조할 수 있다.
람다를 여러줄 작성할 수도 있고, **마지막 줄의 결과가 람다의 반환값**이다.

---

## 🔖 Closure

코틀린에서는 람다가 시작하는 지점에 **참조하고 있는 변수들을 모두 포획**하여 그 정보를 가지고 있다.

이렇게 해야만 람다를 진정한 일급 시민으로 간주할 수 있다.

이러한 데이터 구조를 **`Closure`**라고 부른다.

---

## 🔖 다시 try with resources

실제로 `use`함수는 람다를 받게 만들어진 함수이다.

```kotlin
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader -> println(reader.readLine()) }
}
```

---

# ✅ 코틀린에서 `컬렉션을 함수형`으로 다루는 방법

## 🔖 Filter & Map

다음과 같은 Fruit 클래스가 있을 때, 사과의 가격들을 알고싶으면

```kotlin
data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long
)
```

```kotlin
fun main() {
    val fruits: List<Fruit> = listOf()
    // 필터에서 인덱스가 필요할 경우
    val apples = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }
    
    // 사과의 가격을 알고싶은 경우
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }
    
    // 맵에서 인덱스가 필요한 경우
    val applePricesWithIndex = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice
        }
        
    // 모두 사과인 경우
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }
    
    // 사과가 하나도 없는 경우
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }
}
```

다양한 람다 함수가 있으니까 사용할 때 찾아보면 될듯

---

## 🔖 List to Map

```kotlin
    // 조건으로 묶어서 맵을 만들 경우
    val map: Map<String, List<Long>> = fruits
        .groupBy({ fruit -> fruit.name }, { fruit -> fruit.currentPrice })
    // 뽑아서 맵으로 만들고 싶은 경우
    val map2: Map<Long, Long> = fruits
        .associateBy({fruit -> fruit.id}, { fruit -> fruit.currentPrice })
```

---

## 🔖 중첩된 컬렉션 처리

`flatMap`과 `flatten` 같은 함수들이 있음. → 자바와 같음

---