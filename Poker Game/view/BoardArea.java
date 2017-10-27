package view;

import javafx.scene.layout.HBox;
import model.Board;
import javafx.scene.control.Label;
import model.Card;
import javafx.geometry.Pos;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class BoardArea {

    private HBox pane;

    private Board board;
    private Label pot;

    private CardView[] cards;

    /**
     * Constructor for the board's display
     * @param  board The Board object that contains data associated with the
     * board
     */
    public BoardArea(Board board) {
        this.board = board;

        pane = new HBox();
        cards = new CardView[5];
        pot = new Label("Pot: 0");

        for (int i = 0; i < 5; ++i) {
            cards[i] = new CardView();
            pane.getChildren().add(cards[i]);
        }
        pane.getChildren().add(pot);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(10);

    }

    /**
     * Getter for the HBox that all UI elements are on
     * @return the HBox that all Board UI elements are on
     */
    public HBox getPane() {
        return pane;
    }

    /**
     * Updates UI elements
     */
    public void update() {

        pane.getChildren().clear();
        pot.setText("Pot: " + board.getPot());

        int counter = 0;
        for (Card cardToInput : board.getCards()) {
            cards[counter].setCard(cardToInput);
            if (counter < board.getNumCards()) {
                cards[counter].show();
            } else {
                cards[counter].hide();
            }
            pane.getChildren().add(cards[counter]);
            counter++;
        }

        pane.getChildren().add(pot);

    }

}
