package lec01.java;

import java.util.Arrays;
import java.util.List;

public class Lec01Main {

    public static void main(String[] args) {
        long number1 = 10L; // (1)
        final long number2 = 10L; // (2)

        Long number3 = 10L; // (1)
        Person person = new Person("임준형");

        final List<Integer> numbers = Arrays.asList(1, 2);
        numbers.add(10);    // final 이여도 컬렉션에는 접근 가능
    }
}

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }
}