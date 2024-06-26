package lec15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lec15Main {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(100, 200);

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

        // JDK 8까지
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "MONDAY");
        map.put(2, "TUESDAY");

        // JDK 9부터
        Map.of(1, "Monday", 2, "TUESDAY");
    }
}
