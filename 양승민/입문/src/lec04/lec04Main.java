package lec04;

public class lec04Main {
    public static void main(String[] args) {

        // 1. 비교 연산자
        Integer a = 5;
        Integer b = 5;

        if (a == b) {
            System.out.println("동일성 비교");
        } else if (a.equals(b)) {
            System.out.println("동등성 비교");
        }

        // 3. 연산자 오버로딩
        JavaMoney money1 = new JavaMoney(1_000L);
        JavaMoney money2 = new JavaMoney(2_000L);
        System.out.println(money1.plus(money2));

    }
}
