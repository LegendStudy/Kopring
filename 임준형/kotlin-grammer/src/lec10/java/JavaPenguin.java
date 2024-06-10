package lec10.java;

public class JavaPenguin extends JavaAnimal implements JavaFlyable, JavaSwimable {

    private final int wingCount;

    public JavaPenguin(String species) {
        super(species, 2);
        wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("꽁꽁 얼어붙은 한강 위로 팽귄이 꿱꿱~!");
    }

    @Override
    public int getLegCount() {
        return super.getLegCount() + wingCount;
    }

    @Override
    public void act() {
        JavaFlyable.super.act();
        JavaSwimable.super.act();
    }
}
