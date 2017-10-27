package view;

import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import model.Player;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public abstract class PlayerArea {

    private Pane pane;
    private CardView card0;
    private CardView card1;
    private Label chips;
    private Player player;

    /**
     * PlayerArea's constructor
     * @param  pane   The Pane where all UI elements will be added. The type of
     * pane is decided by subclasses
     * @param  player The Player who's information will be tracked
     */
    public PlayerArea(Pane pane, Player player) {
        this.pane = pane;
        this.player = player;

        card0 = new CardView();
        card1 = new CardView();

        chips = new Label();

        pane.getChildren().addAll(card0, card1, chips);
    }

    /**
     * Getter for the Pane that contains all of the UI elements.
     * @return The Pane that contains all of the UI elements.
     */
    public Pane playerPane() {
        return pane;
    }

    /**
     * This method is called whenever an update to the UI needs to be made.
     * @param showDetails is true whenever the details of the front of the
     * cards are supposed to be shown false otherwise
     */
    public void update(boolean showDetails) {

        card0.setCard(player.getCard(0));
        card1.setCard(player.getCard(1));

        if (showDetails && !player.getOutOfPlay()) {
            card0.show();
            card1.show();
        } else {
            card0.hideDetails();
            card1.hideDetails();
        }

        chips.setText(player.toString() + "\nChips: " + player.getMoney());
        if (player.getOutOfPlay()) {
            chips.setText(chips.getText() + "\nOut of Play");
            card0.hide();
            card1.hide();
        }
    }

}
