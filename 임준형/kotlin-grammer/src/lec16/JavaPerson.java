package lec16;

public class JavaPerson {

    private final String firstName;
    private final String lastName;
    private int age;

    public JavaPerson(final String firstName, final String lastName, final int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int nextYearAge() {
        System.out.println("멤버 함수");
        return this.age + 1;
    }
}
