package lec12.objectANDsingleton;

public class JavaSingleton {
    private static final JavaSingleton INSTANCE = new JavaSingleton();

    private JavaSingleton() {
    }

    public static JavaSingleton getInstance() {
        return INSTANCE;
    }
}
