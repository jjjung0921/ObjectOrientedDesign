package src.factories;

import src.buttons.Button;
import src.buttons.WindowsButton;
import src.checkboxes.CheckBox;
import src.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckbox();
    }
}
