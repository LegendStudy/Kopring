package lec02;

import org.jetbrains.annotations.Nullable;

public class lec02Main {

    public static void main(String[] args) throws IllegalAccessException {
    }

    // 1. Kotlin에서의 null 체크
    // Exception을 내거나
    public static boolean startsWithA1(String str) throws IllegalAccessException {
        if (str == null) {
            throw new IllegalAccessException("null이 들어왔습니다.");
        }
        return str.startsWith("A");
    }

    // null을 반환하거나
    public Boolean startsWithA2(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("A");
    }

    // false를 반환하거나
    public boolean startsWithA3(String str) {
        if(str == null){
            return false;
        }
        return str.startsWith("A");
    }

    // early return
    public long calculate(Long number) {
        if (number == 0) {
            return 0;
        }
        // 다음 로직
    }

}
