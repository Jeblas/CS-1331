/**
 * @author jblasco6
 * @version 1.0
 */
public class SpecialDeck extends ObjectDeck {

    /**
     * Constructor for SpecialDeck
     * @param specialArr Array of Specials
     */
    public SpecialDeck(Special ... specialArr) {
        super((Object[]) specialArr);
    }

    /**
     * Deals a special card
     * @return Special object that has been dealt
     */
    @Override
    public Special deal() {
        return (Special) super.deal();
    }

}
