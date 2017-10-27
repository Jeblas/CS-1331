/**
 * @author jblasco6
 * @version 1.0
 */
public class Player {

    private CardDeck mainDeck;
    private SpecialDeck specialDeck;
    private Card[] hand = new Card[5];
    private Special nextSpecial;
    private int lifePoints;

    /**
     * Return the player's hand
     * @return Player's hand array
     */
    public Card[] getHand() {
        return hand;
    }

    /**
     * Set the hand
     * @param tHand Card array to pass to hand
     */
    public void setHand(Card[] tHand) {
        hand = tHand;
    }

    /**
     * Get the player's special
     * @return Player's nextSpecial
     */
    public Special getNextSpecial() {
        return nextSpecial;
    }

    /**
     * Set the player's nextSpecial
     * @param tNextSpecial Special object to pass to NextSpecial
     */
    public void setNextSpecial(Special tNextSpecial) {
        nextSpecial = tNextSpecial;
    }

    /**
     * Get player's lifepoints
     * @return Player's lifePoints
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Set the player's lifepoints
     * @param tLifePoints number of lifepoints to pass to lifePoints
     */
    public void setLifePoints(int tLifePoints) {
        lifePoints = tLifePoints;
    }

    /**
     * Constructor for player
     * @param tMainD CardDeck Array to become mainDeck
     * @param tSpecD Special Array to become specialDeck
     * @param tLifeP number of lifepoints for player to start with
     */
    public Player(CardDeck tMainD, SpecialDeck tSpecD, int tLifeP) {
        mainDeck = tMainD;
        specialDeck = tSpecD;
        lifePoints = tLifeP;
    }

    /**
     * Constructor for player which sets lifepoints to 5000
     * @param tMainD CardDeck array to become mainDeck
     * @param tSpecD Special array to become specialDeck
     */
    public Player(CardDeck tMainD, SpecialDeck tSpecD) {
        this(tMainD, tSpecD, 5000);
    }

    /**
     * Draw a card from a deck
     * @param count Number of cards to draw
     * @return if all cards to be drawn were
     */
    public boolean draw(int count) {
        Card temp;
        for (int i = 0; i < count; i++) {
            temp = mainDeck.deal();
            if (temp != null) {
                for (int k = 0; k < 5; k++) {
                    if (hand[k] == null) {
                        hand[k] = temp;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Draw a special card from the specialDeck
     */
    public void drawSpecialCard() {
        if (nextSpecial == null) {
            nextSpecial = (Special) specialDeck.deal();
        }
    }

    /**
     * Draws a card from the mainDeck and specialDeck
     */
    public void nextTurnPrep() {
        if (!draw(1)) {
            changeLifePoints(-500);
        }
        drawSpecialCard();
    }

    /**
     * Play selected card to the field
     * @param whichCard index of card to play
     * @param myField Field of the player
     * @return if the card was played
     */
    public boolean playCardFromHand(int whichCard, Field myField) {
        if (whichCard >= 0 && whichCard < 5) {
            if (hand[whichCard] == null) {
                return false;
            } else if (hand[whichCard] instanceof MonsterCard) {
                if (myField.addMonsterCard((MonsterCard) hand[whichCard])) {
                    hand[whichCard] = null;
                    return true;
                }
                return false;
            } else if (hand[whichCard] instanceof SpellCard) {
                if (myField.addSpellCard((SpellCard) hand[whichCard])) {
                    hand[whichCard] = null;
                    return true;
                }
                return false;
            } else if (hand[whichCard] instanceof TrapCard) {
                //hand[whichCard].
                hand[whichCard] = null;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    /**
     * Play special card to field
     * @param myField Players field
     * @return if the special was played
     */
    public boolean playSpecial(Field myField) {
        if (getNextSpecial() != null && getNextSpecial() instanceof Special) {
            if (getNextSpecial() instanceof MonsterCard) {
                if (myField.addMonsterCard((MonsterCard) getNextSpecial())) {
                    setNextSpecial(null);
                    return true;
                }
            } else if (getNextSpecial() instanceof SpellCard) {
                if (myField.addSpellCard((SpellCard) getNextSpecial())) {
                    setNextSpecial(null);
                    return true;
                }
            } else if (getNextSpecial() instanceof TrapCard) {
                setNextSpecial(null);
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Change the player's lifepoints by a given amount
     * @param change amount to add to the player's lifepoints
     */
    public void changeLifePoints(int change) {
        setLifePoints(getLifePoints() + change);
    }

    /**
     * Check if the player has lifepoints <= 0
     * @return if the player is out of lifepoints
     */
    public boolean isDefeated() {
        if (getLifePoints() <= 0) {
            return true;
        }
        return false;
    }

}
