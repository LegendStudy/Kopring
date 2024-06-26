package lec12.objectANDsingleton;

public class JavaPerson {
    private static final int MIN_AGE = 1;

    private String name;
    private int age;

    private JavaPerson(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public static JavaPerson from(final String name) {
        return new JavaPerson(name, MIN_AGE);
    }
}
