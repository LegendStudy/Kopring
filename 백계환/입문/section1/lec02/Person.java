package section1.lec02;

import org.jetbrains.annotations.Nullable;

public class Person {

    private final String name;
    private final Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
