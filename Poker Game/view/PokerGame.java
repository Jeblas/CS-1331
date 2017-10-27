package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import viewcontroller.PokerGameController;
import viewcontroller.GameState;
import javafx.geometry.Pos;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class PokerGame extends Application {

    public static Stage primaryStage;
    private GameScreen gameScreen;
    private PokerGameController pgController;
    private Console console;
    private ControlPane controlPane;
    private Scene scene;

    private VBox gameDisplay;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     * @param ps The primary Stage
     */
    public void start(Stage ps) {
        primaryStage = ps;

        StartScreen startScreen = new StartScreen(this);
        Scene scene1 = new Scene(startScreen);
        primaryStage.setTitle("Start Screen");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    /**
     * Starts the Game
     * This is called by StartScreen whenever it is done and the GameScreen,
     * ControlPane, and Console should be displayed
     * @param name The name of the human player
     */
    public void startGame(String name) {
        pgController = new PokerGameController(this, name);

        gameScreen = new GameScreen(pgController);

        console = new Console();
        controlPane = new ControlPane(pgController);
        controlPane.setAlignment(Pos.CENTER);

        gameDisplay = new VBox();

        gameDisplay.setAlignment(Pos.CENTER);

        gameDisplay.getChildren().addAll(gameScreen, controlPane, console);
        scene = new Scene(gameDisplay);
        primaryStage.setTitle("Extreme Poker");
        primaryStage.setScene(scene);
        primaryStage.show();
        pgController.start();
    }

    /**
     * This is called by PokerGameController whenever updates are made. You
     * must handle updating the UI here.
     */
    public void updatesMade() {

        if (pgController.getState() == GameState.HUMAN_BET) {
            controlPane.playerTurn();
            //gameScreen.updatesMade();
        }

        if (pgController.getState() == GameState.DONE) {
            controlPane.endOfRound();
            gameScreen.endOfRound();
        } else {
            gameScreen.updatesMade();
        }

        if (pgController.getState() == GameState.AI_BET) {

            //disable buttons
            controlPane.aiTurn();
            //controlPane.endOfRound();
        }
        //controlPane.playerTurn();

        //gameScreen.updatesMade();
        //gameDisplay.getChildren().clear();
        //gameDisplay.getChildren().addAll(gameScreen, controlPane, console);
    }

    /**
     * This is the main method that launches the javafx application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
