package view;

import javafx.scene.layout.BorderPane;
import viewcontroller.PokerGameController;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class GameScreen extends BorderPane {

    private HorizontalPlayer topPlayer;
    private HorizontalPlayer bottomPlayer;
    private VerticalPlayer leftPlayer;
    private VerticalPlayer rightPlayer;
    private BoardArea boardArea;
    /**
     * GameScreen's constructor
     * @param controller The PokerGameController to interact with
     */
    public GameScreen(PokerGameController controller) {

        topPlayer = new HorizontalPlayer(controller.getTopPlayer());
        bottomPlayer = new HorizontalPlayer(controller.getBottomPlayer());
        leftPlayer = new VerticalPlayer(controller.getLeftPlayer());
        rightPlayer = new VerticalPlayer(controller.getRightPlayer());
        boardArea = new BoardArea(controller.getBoard());

        this.setTop(topPlayer.playerPane());
        this.setLeft(leftPlayer.playerPane());
        this.setRight(rightPlayer.playerPane());
        this.setBottom(bottomPlayer.playerPane());
        this.setCenter(boardArea.getPane());
    }

    /**
     * This method is called whenever normal updates to the UI need to be made.
     */
    public void updatesMade() {

        topPlayer.update(false);
        bottomPlayer.update(true);
        leftPlayer.update(false);
        rightPlayer.update(false);
        boardArea.update();
        //this.setTop(topPlayer.playerPane());
        //this.setBottom(bottomPlayer.playerPane());
        //this.setLeft(leftPlayer.playerPane());
        //this.setRight(rightPlayer.playerPane());
        //this.setCenter(boardArea.getPane());
    }

    /**
     * This method is called whenever a round of poker ends
     */
    public void endOfRound() {

        topPlayer.update(true);
        bottomPlayer.update(true);
        leftPlayer.update(true);
        rightPlayer.update(true);
        boardArea.update();
        //this.setTop(topPlayer.playerPane());
        //this.setBottom(bottomPlayer.playerPane());
        //this.setLeft(leftPlayer.playerPane());
        //this.setRight(rightPlayer.playerPane());
    }
}
