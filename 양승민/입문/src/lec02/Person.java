package lec02;

import org.jetbrains.annotations.Nullable;

// 4. 플랫폼 타입
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Nullable
    public String getName() {
        return name;
    }

}
