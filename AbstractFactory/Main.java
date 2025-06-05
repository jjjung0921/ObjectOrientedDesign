import src.app.Application;
import src.factories.GUIFactory;
import src.factories.MacOSFactory;
import src.factories.WindowsFactory;

public class Main {
    private static Application configureApplication() {
        GUIFactory factory;
        Application app;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
