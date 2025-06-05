package Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("Hello");
        Singleton singleton1 = Singleton.getInstance("Hello");
        System.out.println(singleton == singleton1); //true
    }
}
