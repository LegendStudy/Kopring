package lec15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lec15MainJava {

    public static void main(String[] args) {

        iter();

        HashMap<Integer, String> odlmap = new HashMap<>();
        odlmap.put(1, "MONDAY");
        odlmap.put(2, "TUESDAY");

        // JDK 8부터
        Map.of(1, "MONDAY", 2, "TUESDAY");
    }

    private static void iter() {
        final List<Integer> numbers = Arrays.asList(100, 200);

        // 하나를 가져오기
        System.out.println(numbers.get(0));

        for (Integer number : numbers) {
            System.out.println(number);
        }

        // 전톡적인 for 문
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%s %s", i, numbers.get(i));
        }
    }
}
