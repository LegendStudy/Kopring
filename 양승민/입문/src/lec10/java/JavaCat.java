package lec10.java;

public class JavaCat extends JavaAnimal {
    public JavaCat(String species, int legCount) {
        super(species, 4);
    }

    @Override
    public void move() {
        System.out.println("꽁꽁 얼어붙은 한강 위에 고양이가 어쩌구");
    }
}
