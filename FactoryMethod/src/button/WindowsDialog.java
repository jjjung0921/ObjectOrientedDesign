package button;

import framework.Button;
import framework.Dialog;

public class WindowsDialog extends Dialog {

    private static WindowsDialog windowsDialog;

    private WindowsDialog() {
        // Private constructor to prevent instantiation
    }

    public static synchronized WindowsDialog getInstance() {
        if (windowsDialog == null) {
            windowsDialog = new WindowsDialog();
        }
        return windowsDialog;
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
