package view;

import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class StartScreen extends StackPane {

    // Path to the image file for the background
    private static final String BACK_LOCATION = "File:./src/main/res"
        + "/poker-game-background.png";

    /**
     * StartScreen's constructor
     * @param cont The PokerGame to interact with
     */
    public StartScreen(PokerGame cont) {
        final String name;
        Image image = new Image(BACK_LOCATION);
        ImageView iv1 = new ImageView();
        //TextInputDialog nameInput;
        iv1.setImage(image);

        Button button = new Button("Start New Game");
        button.setTranslateX(-450);
        button.setTranslateY(250);
        button.setOnAction(e -> {
                TextInputDialog nameInput = new TextInputDialog();
                nameInput.setTitle("New Game");
                nameInput.setContentText("Enter your name:");
                Optional<String> result = nameInput.showAndWait();
                cont.startGame(result.get());
            }
        );

        this.getChildren().addAll(iv1, button);
    }

}
