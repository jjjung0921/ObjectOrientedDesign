package button;
import framework.Button;
import framework.Dialog;

public class HtmlDialog extends Dialog {
    private static HtmlButton htmlButton;

    private HtmlDialog() {
        // Private constructor to prevent instantiation
    }

    public static synchronized HtmlDialog getInstance() {
        if (htmlButton == null) {
            htmlButton = new HtmlButton();
        }
        return new HtmlDialog();
    }

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
