/**
 * @author jblasco6
 * @version 1.0
 */
public class CardDeck extends ObjectDeck {

    /**
     * Constructor of CardDeck
     * @param cardArr array of Card objects
     */
    public CardDeck(Card...cardArr) {
        super((Object[]) cardArr);
    }

    /**
     * Deals the highest index non null Card
     * @return Card object to be delt
     */
    @Override
    public Card deal() {
        return (Card) super.deal();
    }
}
