package Singleton;

public class Singleton {
    private static volatile Singleton instance; //메인 메모리를 통한 인스턴스 가시성

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Singleton.class) { //thread-safe
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
