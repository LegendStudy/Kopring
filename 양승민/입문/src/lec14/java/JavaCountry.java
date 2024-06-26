package lec14.java;

public enum JavaCountry {

    KOREA("KO"),
    AMERICA("US");

    private final String code;

    JavaCountry(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static void handleCountry(JavaCountry country) {
        if (country == JavaCountry.KOREA) {
            // 로직
        }

        if (country == JavaCountry.AMERICA) {
            // 로직
        }
    }
}
