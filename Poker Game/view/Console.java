package view;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class Console extends ScrollPane {

    private static Console instance;
    //private String labelText;
    private static Label consoleLabel;


    /**
     * Console's constructor. Set's the static instance variable.
     */
    public Console() {
        instance = this;

        consoleLabel = new Label();
        consoleLabel.setWrapText(true);
        instance.
        //instance.getChildren().add(consoleLabel);
        instance.setContent(consoleLabel);
        instance.setVbarPolicy(ScrollBarPolicy.NEVER);
    }

    /**
     * Add's text to the top of the console. (Doesn't get rid of
     * text that is already there!)
     * @param newText is the text to add to the top of the console
     */
    public void addText(String newText) {
        instance.setVvalue(0);
        consoleLabel.setText(newText + "\n" + consoleLabel.getText());
    }

    /**
     * Clears the console of any text
     */
    public void clear() {
        consoleLabel.setText("");
    }

    /**
     * Static method that adds a message into the current
     * {@value  instance}
     * @param message The message to add
     */
    public static void putMessage(String message) {
        instance.addText(message);
    }

    /**
     * Clears the console of the current {@value instance}
     */
    public static void clearLog() {
        instance.clear();
    }
}
