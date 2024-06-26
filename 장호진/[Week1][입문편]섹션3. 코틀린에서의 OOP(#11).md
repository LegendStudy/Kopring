---
​
코틀린을 배우는 과정에서 클래스와 객체에 대해 이해하는 것은 매우 중요합니다. 이번 포스트에서는 코틀린에서 클래스, 프로퍼티, 생성자, 접근 지시자, 그리고 다양한 클래스 관련 기능들을 다루는 방법에 대해 자세히 살펴보겠습니다.
​
### 1\. 프로퍼티와 getter/setter
​
코틀린에서는 필드를 만들면 getter와 (필요에 따라) setter가 자동으로 생성되며, 이를 프로퍼티라고 부릅니다. 또한, 주생성자가 필수이며, `constructor` 키워드를 사용해 부생성자를 추가로 만들 수 있습니다.
​
-   **프로퍼티 예제:**
-   `class Person(val name: String, var age: Int)`
-   **커스텀 getter와 setter:**  
    실제 메모리에 존재하는 것과 무관하게 커스텀 getter와 setter를 만들 수 있으며, 무한 루프를 막기 위해 `field` 키워드를 사용합니다.
-   `class Rectangle(var height: Double, var length: Double) { var perimeter = (height + length) * 2 get() = field set(value) { field = value // 추가적인 로직 } }`
​
### 2\. 상속과 오버라이딩
​
코틀린에서는 상속을 위해 `:`을 사용하며, 생성자를 반드시 호출해야 합니다. 또한, `override`를 필수로 명시해야 하며, 추상 멤버가 아니면 기본적으로 오버라이드가 불가능합니다.
​
-   **상속과 오버라이딩:**
-   `open class Shape { open fun draw() { // ... } } class Circle : Shape() { override fun draw() { // ... } }`
-   **클래스 멤버 선언 키워드:**
    -   **final:** `override`를 할 수 없게 합니다. 기본값으로 설정됩니다.
    -   **open:** `override`를 허용합니다.
    -   **abstract:** 반드시 `override` 해야 합니다.
    -   **override:** 상위 타입을 오버라이드 합니다.
        
        ```
        open class Base {
          open fun v() {}
          fun nv() {}
        }
        ```
        class Derived() : Base() {}
​
-   `override fun v() {}`
​
### 3\. 접근 지시자와 패키지 관리
​
코틀린에서 패키지는 네임스페이스 관리용으로 사용되며, `internal` 키워드를 통해 모듈 간 접근을 통제합니다. 생성자에 접근 지시어를 붙일 때는 `constructor`를 명시적으로 사용해야 합니다.
​
-   **접근 지시자:**
-   `class Example private constructor() { // ... }`
-   **모듈 간 접근 통제:**
-   `internal class InternalClass { // ... }`
-   **유틸성 함수:**  
    유틸성 함수를 만들 때는 파일 최상단에 선언하면 편리합니다.좋아, 그럼 나머지 부분을 포함해서 계속 정리해줄게.
-   `fun utilFunction() { // ... }`
​
---
​
### 4\. companion object와 싱글톤
​
코틀린에서는 `companion object`를 사용해 자바의 static 변수와 함수를 만들 수 있으며, 싱글톤 클래스를 만들 때는 `object` 키워드를 사용합니다. `companion object`도 하나의 객체로 간주되기 때문에 이름을 붙일 수 있고, 다른 타입을 상속받을 수도 있습니다.
​
-   **companion object 예제:**
-   `class MyClass { companion object { fun create(): MyClass = MyClass() } }`
-   **싱글톤 예제:**
-   `object Singleton { fun show() { println("Singleton") } }`
​
### 5\. 내부 클래스와 중첩 클래스
​
코틀린에서 클래스 안에 클래스가 있는 경우, 바깥 클래스를 참조하려면 `inner` 키워드를 사용해야 합니다. 기본적으로 중첩 클래스는 바깥 클래스를 참조하지 않습니다. 코틀린의 `inner` 클래스에서는 바깥 클래스를 참조하려면 `this@OuterClass`를 사용합니다.
​
-   **내부 클래스 예제:**
-   `class Outer { private val bar: Int = 1 inner class Inner { fun foo() = bar } }`
-   **중첩 클래스 예제:**
-   `class Outer { class Nested { fun foo() = 2 } }`
​
### 6\. Data class와 Enum class
​
코틀린의 Data class를 사용하면 `equals`, `hashCode`, `toString`을 자동으로 생성합니다. 또한, `copy` 메서드를 제공하여 객체를 복사할 수 있습니다.
​
-   **Data class 예제:**
-   `data class User(val name: String, val age: Int) val user1 = User("Alice", 25) val user2 = user1.copy(age = 26)`
​
코틀린의 Enum class는 자바와 동일하지만, `when`과 함께 사용할 때 큰 장점을 갖습니다.
​
-   **Enum class 예제:**
-   `enum class Color { RED, GREEN, BLUE } fun printColor(color: Color) { when (color) { Color.RED -> println("Red") Color.GREEN -> println("Green") Color.BLUE -> println("Blue") } }`
​
### 7\. Sealed class
​
Sealed class는 Enum class보다 유연하며, 하위 클래스를 제한할 수 있습니다. `when`과 함께 주로 사용됩니다.
​
-   **Sealed class 예제:**
-   `sealed class Expr { class Const(val number: Double) : Expr() class Sum(val e1: Expr, val e2: Expr) : Expr() object NotANumber : Expr() } fun eval(expr: Expr): Double = when (expr) { is Expr.Const -> expr.number is Expr.Sum -> eval(expr.e1) + eval(expr.e2) Expr.NotANumber -> Double.NaN }`
​
### 8\. 예외 처리 (try-catch-finally)
​
코틀린에서 try-catch-finally 구문은 자바와 문법적으로 동일하지만, 코틀린에서는 try-catch가 Expression으로 사용됩니다. 모든 예외는 Unchecked Exception입니다.
​
-   **try-catch-finally 문법:**
-   `val result = try { performOperation() } catch (e: ArithmeticException) { println("Caught ArithmeticException") } finally { println("Cleanup") }`
-   **코틀린의 Unchecked Exception:**  
    코틀린에서는 모든 예외가 Unchecked Exception입니다.
-   **try with resources 없음:**  
    코틀린에서는 try with resources 구문이 없으며, 대신 언어적 특징을 활용해 close를 호출합니다.
​
### 9\. 함수
​
코틀린의 함수 문법은 자바와 다르며, `fun` 키워드를 사용합니다. 함수의 body가 하나의 값으로 간주되는 경우 block을 생략할 수 있습니다.
​
-   **함수 문법:**
-   `fun sum(a: Int, b: Int): Int { return a + b }`
-   **block 생략:**  
    block이 없다면 반환 타입을 생략할 수 있습니다.
-   `fun sum(a: Int, b: Int) = a + b`
-   **기본값을 설정할 수 있는 함수 파라미터:**
-   `fun greet(name: String = "World") { println("Hello, $name!") }`
-   **특정 파라미터를 지정하여 함수 호출 가능:**
-   `fun reformat(str: String, normalizeCase: Boolean = true, upperCaseFirstLetter: Boolean = true, divideByCamelHumps: Boolean = false, wordSeparator: Char = ' ') { // ... } reformat(str = "hello", wordSeparator = '_')`
-   **가변인자:**  
    가변인자에는 `vararg` 키워드를 사용하며, 가변인자 함수를 배열과 호출할 때는 `*`를 붙여주어야 합니다.
-   `fun <T> asList(vararg ts: T): List<T> { val result = ArrayList<T>() for (t in ts) // ts is an Array result.add(t) return result } val list = asList(1, 2, 3)`
​
---
