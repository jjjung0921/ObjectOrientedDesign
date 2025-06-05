import framework.Dialog;
import button.HtmlDialog;
import button.WindowsDialog;

public class Main {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = WindowsDialog.getInstance();
        } else{
            dialog = HtmlDialog.getInstance();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}