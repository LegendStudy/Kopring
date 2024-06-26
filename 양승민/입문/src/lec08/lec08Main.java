package lec08;

public class lec08Main {
    public static void main(String[] args) {

        // 4. 같은 타입의 여러 파라미터 받기 (가변인자)
        String[] array = new String[]{"A", "B", "C"};
        printAll(array);

        printAll("A", "B", "C");
    }

    // 1. 함수 선언 문법
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    // 2. default parameter
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

    // 4. 같은 타입의 여러 파라미터 받기 (가변인자)
    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }

}
