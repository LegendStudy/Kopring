package lec09;

// 1. 클래스와 프로퍼티
public class JavaPerson {

    private final String name;
    private int age;

    // 2. 생성자와 init
    public JavaPerson(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException(String.format("나이(%s)가 이상함", age));
        }
        this.name = name;
        this.age = age;
    }

    public JavaPerson(String name) {
        this(name, 1);
    }

    public JavaPerson() {
        this("양승민");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 3. 커스텀 getter, setter
    public boolean isAdult() {
        return this.age >= 20;
    }
}
