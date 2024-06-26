package lec11;

public abstract class JavaStringUtils {

    public JavaStringUtils() {
    }

    public boolean isDirectoryPath(String path) {
        return path.endsWith("/");
    }

    public static void main(String[] args) {
        StringUtilsKt.isDirectoryPath("/");
    }
}
