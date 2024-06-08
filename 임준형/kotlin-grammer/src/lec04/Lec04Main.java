package lec04;

public class Lec04Main {
    public static void main(String[] args) {

        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);
        JavaMoney money3 = new JavaMoney(2_000L);
        JavaMoney money4 = money1;

        if (money1.compareTo(money2) > 0) {
            System.out.println("Money1이 Money2보다 금액이 큽니다.");
        }

        System.out.println(money1 == money3);   // false, equlas overrinng 하면 바뀜
    }
}
