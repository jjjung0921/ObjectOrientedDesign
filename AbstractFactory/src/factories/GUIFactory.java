package src.factories;

import src.buttons.Button;
import src.checkboxes.CheckBox;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
