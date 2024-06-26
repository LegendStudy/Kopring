package lec10.java;

public class JavaCat extends JavaAnimal {
    public JavaCat(String species) {
        super(species, 4);
    }

    @Override
    public void move() {
        System.out.println("꽁꽁 얼어붙은 한강위로 고양이가 걸어다닙니다.");
    }
}
