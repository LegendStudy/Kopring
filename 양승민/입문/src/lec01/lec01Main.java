package lec01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class lec01Main {
    public static void main(String[] args) {

        // 1. 변수 선언 키워드: var과 val의 차이점
        long number1 = 10L;
        final long number2 = 10L;

        // 2. Java에서의 기본형 타입
        Long number3 = 1_000L;

        // ++ Java에서의 컬렉션
        List<Integer> numbers = new ArrayList<>();

        // 3. Kotlin에서의 nullable 변수
        Optional<Long> number4 = null;

        // 4. Kotlin에서의 객체 인스턴스화
        Person person = new Person("양승민");

    }
}
