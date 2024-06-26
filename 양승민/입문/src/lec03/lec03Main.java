package lec03;

public class lec03Main {
    public static void main(String[] args) {

        // 1. 기본 타입
        // 암시적 변환
        int numberInt = 4;
        long numberLong = numberInt;
    }

    // 2. 타입 캐스팅
    public static void printAgeIfPerson(Object object) {
        if(object instanceof Person){
            Person person = (Person) object;
            System.out.println(person.getAge());
        }
    }

    // 4-1. String Interpolation
    Person person = new Person("양승민", 100);
    String log = String.format("사람의 이름은 %s이고 나이는 %s세 입니다", person.getName(), person.getAge());


    // 4-2. String Indexing
    String str = "ABCDE";
    char ch = str.charAt(1);

}
