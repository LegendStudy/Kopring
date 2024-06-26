package lec05;

public class lec05Main {
    public static void main(String[] args) {
        // 2. Expression & Statement
        int score = 30 + 40;

        String grade3 = score >= 50 ? "P" : "F";

        if (0 <= score && score <= 100) {
            System.out.println("0~100");
        }

    }

    // 1. if문
    private void validateScoreIsNotNegative(int score) {
        if (score < 0) {
            throw new IllegalArgumentException(String.format("%s는 0보다 작을 수 없습니다.", score));
        }
    }

    // 3. Switch & When
    private String getGradeWithSwitch(int score) {
        switch (score / 10) {
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            default:
                return "D";
        }
    }

}
