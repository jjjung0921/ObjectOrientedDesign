package framework;

import button.WindowsDialog;

public abstract class Dialog {
    private static Dialog dialogInstance;

    private Dialog() {
        // Private constructor to prevent instantiation
    }

    public synchronized static Dialog getInstance() {
        if (dialogInstance == null) {
            dialogInstance = new WindowsDialog(); // Default implementation
        }
        return dialogInstance;
    }

    public void renderWindow(){
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
