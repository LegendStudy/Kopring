package section3.lec10.java;

public class JavaPenguin extends JavaAnimal {

    private final int wingCount;

    public JavaPenguin(String species) {
        super(species, 2);
        this.wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("펭귄이 움직인다.");
    }

    @Override
    public int getLegCount() {
        return super.legCount + this.wingCount;
    }
}
