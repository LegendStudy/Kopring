# 섹션3 코틀린에서의 OOP

## 9강 코틀린에서 클래스를 다루는 방법

Kotlin에서 기본 클래스가 마치 Java의 record와 비슷하게 동작.

var이면 자동으로 getter, setter 생성하고 val이면 자동으로 getter를 생성함

생성자 키워드 constructor는 생략 가능하며, 클래스 헤더에 val 및 var 키워드 생성시 필드 또한 자동으로 생성해줌

특이한 건 `init 메서드`가 존재하는데 생성자 호출시 실행하여 validation할 때 자주 사용됨

생성자를 추가로 생성하고 싶은 경우 constructor 키워드를 새로 만들면됨

```kotlin
class Person(
    val name: String,
    var age:Int
) {
    // 생성자가 호출되는 시점에 호출됨
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    constructor(name: String) : this(name, 3) {
        println("첫 번째 부 생성자")
    }

    constructor() : this("홍길동") {
        println("두 번째 부 생성자")
    }
}
```

하지만 Kotlin에서는 기본 값을 사용하는 걸 추천함

### Custom Getter
아래 2개의 메서드는 같은 의미. isAdult라는 값 자체를 만들고, get으로 isAdult를 요청했을 경우 아래를 반환

프로퍼티 인것처럼 접근하는지, 함수인 것 처럼 접근하는지를 확인하고 아래 2가지 방식 중 하나로 결정
```kotlin
fun isAdult(): Boolean {
    return this.age >= 20
}

val isAdult: Boolean 
get() = this.age >= 20
```

### backing field

Getter를 자동으로 생성해주지 않고, 커스텀한다면?

Kotlin에서는 get할 때 `person.name` 와 같이 접근함

만약 get을 custom 하고싶다고 해보자. 

생성자 헤더에서 val 키워드를 제거하고, 블록 내부에 val name = name으로 선언 후 아래와 같은 상황이다.

```kotlin
val name = name
    get() = name.uppercase()
```

근데, 오류가 난다. 그 이유는 외부에서 name을 호출 했을 때 name은 다시 get을 호출을 무한반복하게 됨

그러므로 `name.uppercase()`가 아닌 `field.uppercase`로 접근해야함

```kotlin
val name = name
    get() = field.uppercase()
```

자기자신을 가리키는, 보이지 않는 Field 이므로 backing field라고 부름

위 상황에서 실제로 저장은 소문자로 되고, get() 할 때는 대문자로 반영이됨

하지만 이런식으로는 실제로 많이 사용하지 않고, 아래와 같이 실제로는 없는 값이지만 외부에는 있는 것처럼 보일 때는 아래와 같이 쓰임 

```kotlin
val uppercaseName: String
    get() = this.name.uppercase()   
```

## 10강 코틀린에서 상속을 다루는 방법

추상 클래스를 상속할 때는 문제가 없지만 일반 클래스를 상속할 때는 `class`에 `open`을 꼭 붙여줘야 함

오버라이드를 할 때 자바에서는 `@Override`를 사용했지만, Kotlin에선 메서드 키워드에 `override`를 사용함

상위 클래스에서 정의한 필드의 getter를 오버라이딩 하고 싶으면 상위 클래스의 필드에 open을 붙여줘야하는데,, 그냥 안하는게 좋음

상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티는 open을 피해야 함

open 역할: override를 열어준다

## 11강 코틀린에서 접근 제어를 다루는 방법

### 자바의 접근 제어자

| 접근 제어자  | 설명                                          |
|--------------|---------------------------------------------|
| `public`     | 모든 곳에서 접근 가능                        |
| `protected`  | 같은 패키지 또는 하위 클래스에서만 접근 가능  |
| `default`    | 같은 패키지에서만 접근 가능                  |
| `private`    | 선언된 클래스 내에서만 접근 가능             |

### 코틀린의 접근 제어자

| 접근 제어자  | 설명                                           |
|--------------|----------------------------------------------|
| `public`     | 모든 곳에서 접근 가능                                 |
| `protected`  | 선언된 클래스 또는 하위 클래스에서만 접근 가능 (같은 패키지가 빠졌다고 생각) |
| `internal`   | 같은 모듈에서만 접근 가능                               |
| `private`    | 선언된 클래스 내에서만 접근 가능                           |

### Util Method

#### Java
추상 클래스로 생성 후 생성자를 막아 인스턴스화 할 수 없게하고, 메서드를 만들어 사용

```java
public abstract class JavaStringUtils {

    public JavaStringUtils() {
    }

    public boolean isDirectoryPath(String path) {
        return path.endsWith("/");
    }

    public static void main(String[] args) {
        StringUtilsKt.isDirectoryPath("/");
    }
}
```
#### Kotlin
그냥 파일에 선언 후 import하면 끝
```kotlin
// StringUtils.kt
package lec11

fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}
```

```kotlin
// Main Class
package lec11

class Lec11Main {
    fun main() {
        isDirectoryPath("/")
    }
}
```

## 12강 코틀린에서 object 키워드를 다루는 방법

Java에서 static 클래스를 Kotlin에선 아래와 같이 `companion object`표현

```kotlin
companion object Factory : Log {
    private const val MIN_AGE = 1
    fun newBaby(name: String): Person {
        return Person(name, MIN_AGE)
    }

    @JvmStatic
    override fun log() {
        println("나는 Person 클래스 동행 객체에요")
    }
}
```

외부에선 아래와 같이 적용 가능하며 마찬가지로 static import와 유사하게 가능

```kotlin
Person.newBaby("hello")
```

Java에서 컴패니언 사용하려면 @JvmStatic을 붙여야함

### 싱글톤

object 키워드 쓰면 끝

### 익명클래스 구현시

```kotlin
moveSomething(object : Moveable {
    override fun move() {
        println("움직인다")
    }

    override fun fly() {
        println("난다")
    }
})
```

## 13강 코틀린에서 중첩 클래스를 다루는 방법

Effecttive Java에서는 내부 클래스를 생성하는 것보다, static을 사용하는 것을 권장함

Kotlin에서는 이 권장사항을 따라 자동으로 static과 같이 동작함

inner는,, 권장하니 않으니 알아보지도 말자

### Java
| 클래스 안의 static 클래스 | 바깥 클래스 참조 없음<br/> 권장되는 유형                    |
|------------------|----------------------------------------------|

### Kotlin
| 클래스 안의 클래스 | 바깥 클래스 참조 없음<br/> 권장되는 유형                    |
|-----------------|----------------------------------------------|
