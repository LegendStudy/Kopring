package lec02.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }

//    @Nullable
    @NotNull
    public String getName() {
        return name;
    }
}