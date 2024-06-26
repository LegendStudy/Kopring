# [Section 2] 코드를 제어하는 방법

# ✅ 코틀린에서 `조건문`을 다루는 방법

## 🔖 if문

```java
    private void validateScoreIsNotNegative(int score) {
        if (score < 0) {
            throw new IllegalArgumentException(String.format("%s는 0보다 작을 수 없습니다.", score));
        }
    }
```

```kotlin
    fun validateScoreIsNotNegative(score: Int) {
        if (score < 0) {
            throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
        }
    }
```

---

## 🔖 Expression과 Statement

### Expression → 하나의 값으로 도출 되는 문장

### Statement → 하나의 값으로 도출 되지 않는 프로그램의 문장

예를 들어, 아래와 같은 예시는 70이라는 하나의 결과가 나온다.

`Expression`이면서 `Statement`라고 할 수 있다.

```java
int score = 30 + 40;
```

```java
    String grade = if(score>=50) {  // 잘못된 코드
        "P";
    }else{
        "F";
    }
```

위처럼 if문을 하나의 값으로 취급하지 않는다. 

```java
String grade3 = score >= 50 ? "P" : "F";
```

반대로 3항 연산자는 하나의 값으로 취급하므로 에러가 없다.
(`Expression`이면서 `Statement`이다.)

이처럼 Java에서 if-else는 `Statement`이지만, Kotlin에서는 `Expression`이다.

```kotlin
    fun getPassOrFail(score: Int): String {
        return if (score >= 50) {
            "P"
        } else {
            "F"
        }
    }
```

Kotlin에서는 if-else를 `Expression`으로 사용할 수 있기 때문에 **3항 연산자가 없다.**

어떤 값이 범위에 포함되어 있는지를 확인할 경우

```java
        if (0 <= score && score <= 100) {
            System.out.println("0~100");
        }
```

```kotlin
    if (score in 0..100) {
        println("0~100")
    }
```

위처럼 `in` 연산자를 활용할 수 있다.

**코틀린 공식 문서 중..**

> 숫자, 문자, 불리언과 같은 몇몇 타입은 내부적으로 특별한 표현을 갖는다.
이 타입들은 실행시에 기본형 값으로 표현되지만, 코드에서는 평법한 클래스처럼 보인다.
> 

따라서 프로그래머가 `boxing/unboxing`을 고려하지 않아도 되도록 알아서 처리해줌

~~그니까 성능 문제 걱정 노노~~

---

## 🔖 switch와 when

```java
    private String getGradeWithSwitch(int score) {
        switch (score / 10) {
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            default:
                return "D";
        }
    }
```

```kotlin
    fun getGradeWithSwitch(score: Int): String {
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7 -> "C"
            else -> "D"
        }
    }
```

Kotlin에서는 `switch`가 아닌 `when`을 사용한다.

```kotlin
    fun getGradeWithSwitch2(score: Int): String {
        return when (score) {
            in 90..99 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else ->"D"
        }
    }
```

```kotlin
    fun startsWithA(obj: Any): Boolean {
        return when (obj) {
            is String -> obj.startsWith("A")
            else -> false
        }
    }
```

위처럼 조건문에 어떠한 `Expression`도 들어갈 수 있다.

```kotlin
    fun judgeNumber(number: Int) {
        return when (number) {
            1, 0, -1 -> println("어디서 많이 본 숫잔데?")
            else -> println("1, 0, -1이 아닙니다.")
        }
    }
```

여러 조건도 동시에 묶어서 확인할 수 있다.

```kotlin
    fun judgeNumber2(number: Int) {
        return when {
            number == 0 -> println("주어진 숫자는 0입니다")
            number %2 == 0-> println("주어진 숫자는 짝수입니다")
            else -> println("주어진 숫자는 홀수입니다")
        }
    }
```

값이 없을 수도 있다. (early return 처럼 동작함)

`when`은 `Enum Class`나 `Sealed Class`와 함께 사용할 경우, 더욱더 진가를 발휘한다.

---

# ✅ 코틀린에서 `반복문`을 다루는 방법

## 🔖 for-each 문

숫자가 들어 있는 리스트를 하나씩 출력한다고 했을 때의 예제는 다음과 같다.

```java
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        for (long number : numbers) {
            System.out.println(number);
        }
```

```kotlin
    val numbers = listOf(1L, 2L, 3L) // 컬렉션을 만들고
    for (number in numbers) { // :대신 in을 사용
        println(number)
    }
```

---

## 🔖 전통적인 for문

1부터 3까지 출력하는 예제는 다음과 같다.

```java
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }
        for (int i = 3; i >= 1; i--) {
            System.out.println(i);
        }
        for (int i = 1; i <= 5; i += 2) {
            System.out.println(i);
        }
```

```kotlin
    for (i in 1..3) { // in을 쓰면됨
        println(i)
    }
    for (i in 3 downTo 1) { // 내려갈 경우는 downTo를 쓰면됨
        println(i)
    }
    for (i in 1..5 step 2) { // 2칸씩 올라갈 경우는 step을 사용
        println(i)
    }

```

---

## 🔖 Progression과 Range

위와 같은 반복문의 동작 원리는 무엇일까?

`..`연산자로 `Range`를 정해주면 `downTo`, `step`같은 `Progression` 함수로 등차수열을 만들어 주는 원리이다.

---

## 🔖 while문

Java와 Kotlin 완전 동일

---

# ✅ 코틀린에서 `예외`를 다루는 방법

## 🔖 try catch finally

주어진 문자열을 정수로 변경할 때,

```java
    private int parseIntOrThrow(@NotNull String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
```

```kotlin
    fun parseIntOrThrow(string: String): Int {
        try{
            return string.toInt() // 기본 타입간 변환은 toType()을 사용
        }catch (e: NumberFormatException){
            throw IllegalArgumentException(e) // new를 안씀 그냥 던짐
        }
    }
```

위와 같은 예제에서 실패하면 null을 반환 할때,

```java
    private Integer parseIntOrThrow2(@NotNull String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }
```

```kotlin
    fun parseIntOrThrow2(string: String): Int? {
        return try{ // try catch도 Expression이기 때문에 이처럼 사용가능
            return string.toInt()
        }catch (e: NumberFormatException){
            null;
        }
    }
```

`try catch finally` 예제도 동일하다.

---

## 🔖 Checked Exception과 Unchecked Exception

Kotlin에서는 `Checked Exception`과 `Unchecked Exception`을 구분하지 않는다.

모두 `Unchecked Exception`으로 취급하기 때문에 메서드에 `throws` 구문을 통해 예외를 던져주지 않는다.

---

## 🔖 try with resources

프로젝트 내 파일의 내용물을 읽어올 때

```java
    public void readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }
```

```kotlin
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader -> // use라는 인라인 확장 함수를 사용한다.
            println(reader.readLine())
        }
    }
```

---

# ✅ 코틀린에서 `함수`를 다루는 방법

## 🔖 함수 선언 문법

두 정수를 받아 더 큰 정수를 반환하는 예제

```java
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
```

```kotlin
    fun max(a: Int, b: Int) = if (a > b) a else b
```

함수가 하나의 결과값이기 때문에 `block` 대신 `=` 을 사용하여 표현 가능하다.

`=`을 사용할 경우에 반환 타입을 생략할 수 있다.

---

## 🔖 default parameter

주어진 문자열을 N번 출력하는 예제

```java
    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    public void repeat(String str, int num) {
        repeat(str, num, true);
    }

    public void repeat(String str) {
        repeat(str, 3, true);
    }
```

```kotlin
    fun repeat(
        str: String,
        num: Int = 3,
        useNewLine: Boolean = true
    ) {
        for (i in 1..num) {
            if (useNewLine) {
                println(str)
            } else {
                print(str)
            }
        }
    }
```

위처럼 자바의 오버로딩을 `default parameter`를 사용해서 심플하게 구현할 수 있다.

---

## 🔖 named argument (parameter)

위 예제에서 `repeat`을 호출할 때, `num`은 3을 그대로 쓰고 `useNewLine`은 `false`로 쓰고 싶다면?

```kotlin
    repeat("Hello world!", useNewLine = false)
```

이처럼 매개변수 이름을 통해서 직접 지정해 줄 수 있다.

---

## 🔖 같은 타입의 여러 파라미터 받기 (가변인자)

문자열 N개를 받아 출력하는 예제

```java
    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }
    
    // 사용시
        String[] array = new String[]{"A", "B", "C"};
        printAll(array);

        printAll("A", "B", "C");
```

```kotlin
    fun printAll(vararg strings: String) {
        for (str in strings) {
            println(str)
        }
    }
    
    // 사용시
    val array = arrayOf("A", "B", "C")
    printAll(*array)

    printAll("A", "B", "C")
```

`vararg`를 통해 받을 수 있다. 메서드 사용시 자바와 다르게 배열을 사용할 경우 `*`를 붙여주어야 한다.

---