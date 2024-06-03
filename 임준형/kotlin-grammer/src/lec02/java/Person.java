package lec02.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Person{
    String name;
    int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    //    @Nullable
    @NotNull
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}