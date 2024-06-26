코틀린을 배우는 과정에서 제어문, 반복문, 예외 처리, 함수에 대해 이해하는 것은 매우 중요합니다. 이번 포스트에서는 코틀린에서 제어문, 반복문, 예외 처리, 그리고 함수를 다루는 방법에 대해 자세히 살펴보겠습니다.
​
### 1\. 제어문 (if, if-else, if-elseif-else)
​
코틀린에서는 제어문이 자바와 동일한 문법을 사용하지만, 코틀린에서는 제어문이 Expression으로 취급됩니다.
​
**if/if-else/if-elseif-else 문법**
​
```
val max = if (a > b) a else b
```
​
-   **Expression으로 취급**: 코틀린에서는 삼항 연산자가 없으며, if-else가 Expression으로 사용됩니다.
-   **when 문법**: 자바의 switch는 코틀린에서 when으로 대체되며, 더 강력한 기능을 갖습니다.
    
    ```
    when (x) {
      1 -> print("x == 1")
      2 -> print("x == 2")
      else -> print("x is neither 1 nor 2")
    }
    ```
    
​
### 2\. 반복문 (for, while, do-while)
​
코틀린의 for-each 문에서 자바는 `:`을, 코틀린은 `in`을 사용합니다. 전통적인 for문에서도 코틀린은 등차수열과 `in`을 사용합니다.
​
**for-each 문법**
​
```
for (item in collection) {
    print(item)
}
```
​
**전통적인 for문**
​
```
for (i in 1..10) {
    print(i)
}
```
​
-   **while문과 do-while문**: 자바와 코틀린은 문법이 동일합니다.
    
    ```
    while (x > 0) {
      x--
    }
    ```
    
​
do {  
val y = retrieveData()  
} while (y != null)
​
````
​
### 3. 예외 처리 (try-catch-finally)
코틀린에서 try-catch-finally 구문은 자바와 문법적으로 동일하지만, 코틀린에서는 try-catch가 Expression으로 사용됩니다.
​
**try-catch-finally 문법**
```kotlin
val result = try {
    performOperation()
} catch (e: ArithmeticException) {
    println("Caught ArithmeticException")
} finally {
    println("Cleanup")
}
````
​
-   **모든 예외는 Unchecked Exception**: 코틀린에서는 모든 예외가 Unchecked Exception입니다.
-   **try with resources 없음**: 코틀린에서는 try with resources 구문이 없으며, 대신 언어적 특징을 활용해 close를 호출합니다.
​
### 4\. 함수
​
코틀린의 함수 문법은 자바와 다르며, 접근지시어 fun 키워드를 사용합니다. 또한, 함수의 body가 하나의 값으로 간주되는 경우 block을 생략할 수 있습니다.
​
**함수 문법**
​
```
fun sum(a: Int, b: Int): Int {
    return a + b
}
```
​
-   **block 생략**: block이 없다면 반환 타입을 생략할 수 있습니다.
-   `fun sum(a: Int, b: Int) = a + b`
-   **기본값을 설정할 수 있는 함수 파라미터**: 함수 파라미터에 기본값을 설정할 수 있습니다.
-   `fun greet(name: String = "World") { println("Hello, $name!") }`
-   **특정 파라미터를 지정하여 함수 호출 가능**
-   `fun reformat(str: String, normalizeCase: Boolean = true, upperCaseFirstLetter: Boolean = true, divideByCamelHumps: Boolean = false, wordSeparator: Char = ' ') { // ... } reformat(str = "hello", wordSeparator = '_')`
-   **가변인자**: 가변인자에는 vararg 키워드를 사용하며, 가변인자 함수를 배열과 호출할 때는 `*`를 붙여주어야 합니다.
-   `fun <T> asList(vararg ts: T): List<T> { val result = ArrayList<T>() for (t in ts) // ts is an Array result.add(t) return result } val list = asList(1, 2, 3)`
​
---
