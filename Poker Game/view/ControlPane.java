package view;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import viewcontroller.PokerGameController;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class ControlPane extends HBox {

    private PokerGameController cont;

    private Button raise;
    private Button call;
    private Button fold;
    private Button startNewRound;
    private TextField betAmt;

    /**
     * Constructor for ControlPane
     * @param  cont The PokerGameController to interact with
     */
    public ControlPane(PokerGameController cont) {
        this.cont = cont;

        betAmt = new TextField();

        raise = new Button("Raise");
        raise.setOnAction(e -> {
                this.cont.humanBet(Integer.parseInt(betAmt.getText()));
                betAmt.setText("");
            }
        );

        call = new Button("Call");
        call.setOnAction(e -> {
                this.cont.humanCall();
            }
        );

        fold = new Button("Fold");
        fold.setOnAction(e -> {
                this.cont.humanFold();
            }
        );

        startNewRound = new Button("Start New Round");
        startNewRound.setOnAction(e -> {
                this.cont.startNewPokerHand();
            }
        );
        startNewRound.setVisible(false);

        this.setSpacing(10);
        this.getChildren().addAll(betAmt, raise, call, fold, startNewRound);
    }

    /**
     * Called whenever it becomes the player's turn again
     */
    public void playerTurn() {
        call.setDisable(false);
        raise.setDisable(false);
        fold.setDisable(false);
        startNewRound.setVisible(false);
        startNewRound.setDisable(true);
    }

    /**
     * Called whenever it is an AI player's turn
     */
    public void aiTurn() {
        call.setDisable(true);
        raise.setDisable(true);
        fold.setDisable(true);
    }

    /**
     * Method called when the round ends.
     */
    public void endOfRound() {
        call.setDisable(true);
        raise.setDisable(true);
        fold.setDisable(true);
        startNewRound.setDisable(false);
        startNewRound.setVisible(true);
    }

}
