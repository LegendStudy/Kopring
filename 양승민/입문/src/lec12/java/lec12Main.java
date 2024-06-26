package lec12.java;

public class lec12Main {
    public static void main(String[] args) {
        moveSomething(new Movable() {

            @Override
            public void move() {
                System.out.println("움직움직");
            }

            @Override
            public void fly() {
                System.out.println("날앙");
            }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.fly();
        movable.move();
    }
}
