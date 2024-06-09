package lec09;

public class JavaPerson {
    private final String name;
    private int age;

    public JavaPerson(final String name, final int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없습니다.", age));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public boolean isAdult() {
        return this.age >= 20;
    }
}
