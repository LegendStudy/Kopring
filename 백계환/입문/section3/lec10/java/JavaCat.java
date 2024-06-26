package section3.lec10.java;

public class JavaCat extends JavaAnimal {

    public JavaCat(String species) {
        super(species, 4);
    }

    @Override
    public void move() {
        System.out.println("꽁꽁 얼어붙은 한강 위로 고양이가 걸어 다닙니다.");
    }
}
