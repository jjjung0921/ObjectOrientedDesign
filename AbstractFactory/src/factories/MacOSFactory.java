package src.factories;

import src.buttons.Button;
import src.buttons.MacOSButton;
import src.checkboxes.CheckBox;
import src.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckbox();
    }
}
