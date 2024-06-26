
---
​
## 코틀린에서 변수와 타입, 연산자를 다루는 방법
​
코틀린을 배우는 과정에서 변수와 타입, 연산자에 대해 이해하는 것은 매우 중요합니다. 이번 포스트에서는 코틀린에서 변수, null, 타입, 그리고 연산자를 다루는 방법에 대해 자세히 살펴보겠습니다.
​
### 1\. 코틀린에서 변수를 다루는 방법
​
코틀린에서 변수를 선언할 때는 `var`와 `val` 키워드를 사용합니다. `var`는 변경 가능한 변수를 의미하며, `val`은 불변 변수를 의미합니다.
​
**var:** 변경 가능한 변수 선언
​
```
var mutableVariable: String = "Hello"
mutableVariable = "World"
```
​
**val:** 변경 불가능한 변수 선언
​
```
val immutableVariable: String = "Hello"
// immutableVariable = "World" // Error: Val cannot be reassigned
```
​
### 2\. 코틀린에서 null을 다루는 방법
​
코틀린에서는 null 안전성을 보장하기 위해 null이 들어갈 수 있는 변수에 `?`를 붙여야 합니다. 이는 완전히 다른 타입으로 간주됩니다.
​
**null 허용 변수:**
​
```
var nullableVariable: String? = null
```
​
**Safe Call (`?.`) 연산자:** null이 아닌 경우에만 호출됩니다.
​
```
val length = nullableVariable?.length
```
​
**Elvis (`?:`) 연산자:** null인 경우 기본값을 반환합니다.
​
```
val length = nullableVariable?.length ?: 0
```
​
**널 아님 단언 (`!!`) 연산자:** 변수가 null이 아님을 단언할 때 사용합니다.
​
```
val length = nullableVariable!!.length
```
​
### 3\. 코틀린에서 타입을 다루는 방법
​
코틀린에서는 타입을 명시적으로 작성하지 않아도 초기값을 기반으로 타입을 추론합니다. 또한, 코틀린에서는 `is`, `!is`, `as`, `as?` 연산자를 사용해 타입을 확인하고 캐스팅합니다.
​
**타입 추론:**
​
```
val number = 10 // Int로 추론
```
​
**타입 검사와 캐스팅:**
​
```
if (number is Int) {
    val doubleNumber = number as Double // Int를 Double로 캐스팅
}
```
​
### 4\. 코틀린에서 연산자를 다루는 방법
​
코틀린에서는 다양한 연산자를 제공하여 코드를 간결하고 읽기 쉽게 만듭니다. 특히, 문자열을 가공할 때 `${변수}`와 `""" """`를 사용하면 깔끔한 코딩이 가능합니다.
​
**문자열 템플릿:**
​
```
val name = "Kotlin"
val greeting = "Hello, $name"
```
​
**멀티라인 문자열:**
​
```
val text = """
    |This is a multi-line
    |string in Kotlin.
    """.trimMargin()
```
​
**문자열에서 문자를 가져올 때 배열처럼 \[ \] 사용:**
​
```
val firstChar = text[0]
```
​
---
