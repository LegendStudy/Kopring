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